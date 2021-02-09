package a01085867.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a01085867.ApplicationException;
import a01085867.data.Runner;

public class RunnerReader {

	private static final Logger LOG = LogManager.getLogger(RunnerReader.class);
	private static final String FIELD_DELIMITER = "\\|";
	private static final String SOURCE_FILE = "athletes.txt";

	public static Map<Integer, Runner> read() throws ApplicationException {
		Map<Integer, Runner> athletes = new HashMap<>();

		File sourceFile = new File(SOURCE_FILE);

		if (!sourceFile.exists()) {
			throw new ApplicationException(String.format("File %s doesn't exist", SOURCE_FILE));
		}
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(sourceFile));
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				Runner runner = readAthlete(line);
				athletes.put(runner.getBibNumber(), runner);
			}
		} catch (IOException e) {
			LOG.debug(e);
			throw new ApplicationException(e.getCause());

		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e) {
				LOG.debug(e);
				throw new ApplicationException(e.getCause());

			}
		}
		return athletes;

	}

	private static Runner readAthlete(String data) throws ApplicationException {
		String[] elements = data.split(FIELD_DELIMITER);

		if (elements.length != Runner.FIELDS) {
			throw new ApplicationException(String.format("Expected %d but got %d", elements.length, Arrays.toString(elements)));
		}

		int index = 0;
		int lane = Integer.parseInt(elements[index++]);
		int bibNumber = Integer.parseInt(elements[index++]);
		String country = elements[index++];
		String lastName = elements[index++];
		String firstName = elements[index++];
		double reaction = Double.parseDouble(elements[index++]);

		try {
			return new Runner.Builder(bibNumber).lane(lane).country(country).lastName(lastName).firstName(firstName).reaction(reaction).build();
		} catch (Exception e) {
			LOG.error("Error exception", e);
			throw new ApplicationException(e.getMessage());
		}

	}

}
