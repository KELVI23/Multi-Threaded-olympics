/**
 * Project: Lab8
 * File: Lab8.java
 * Date: Nov. 15, 2020
 * Time: 12:56:11 p.m.
 */
package a01085867;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import a01085867.data.RaceThread;
import a01085867.data.Runner;
import a01085867.io.RunnerReader;
import a01085867.io.RunnerReport;
import a01085867.sorter.RaceSorter;

/**
 * @author Kelvin Musodza, A01085867
 *
 */
public class Lab8 {

	static {
		configureLogging();
	}

	private final static Logger LOG = LogManager.getLogger(Lab8.class);
	private static final String LOG4J_CONFIG_FILENAME = "log4j2.xml";
	private static final Instant startTime = Instant.now();

	/**
	 * @param args
	 * @throws ApplicationException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException, ApplicationException {
		LOG.info("Start Time: " + startTime);

		new Lab8().start();

	}

	private void start() {
		try {

			Map<Integer, Runner> athletes = RunnerReader.read();
			List<Runner> sortedRunner = new ArrayList<>(athletes.values());

			Thread[] threads = new Thread[sortedRunner.size()];
			Thread thread = null;
			int i = 0;
			for (Runner runner : sortedRunner) {
				thread = new RaceThread(runner);
				threads[i] = thread;
				thread.start();
				i++;
			}

			for (Thread t : threads) {
				t.join(3600000);// 1 hour
			}

			Collections.sort(sortedRunner, new RaceSorter.CompareResult());

			RunnerReport.write(sortedRunner);
		} catch (ApplicationException e) {
			LOG.error(e.getMessage());

			System.exit(-1);
		} catch (InterruptedException e) {
			LOG.error(e.getMessage());
			e.printStackTrace();

		} finally {
			printEndTimeAndDuration();
		}

	}

	private void printEndTimeAndDuration() {
		// TODO Auto-generated method stub

		Instant endTime = Instant.now();
		LOG.info("End Time: " + endTime);

		LOG.info(String.format("Duration: %d ms", Duration.between(startTime, endTime).toMillis()));
	}

	// private Thread RaceThread(Runner runner) {
	//
	// this.runners = runner;
	// setName(String.valueOf(runner.getBibNumber()) + " - " + runner.getFirstName() + " " + runner.getLastName());
	// }

	private static void configureLogging() {
		ConfigurationSource source;
		try {
			source = new ConfigurationSource(new FileInputStream(LOG4J_CONFIG_FILENAME));
			Configurator.initialize(null, source);
		} catch (IOException e) {
			System.err.println(String.format("Can't find the log4j logging configuration file %s.", LOG4J_CONFIG_FILENAME));
		}

	}

}
