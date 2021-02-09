package a01085867.io;

import java.util.Collection;

import a01085867.ApplicationException;
import a01085867.data.Runner;

public class RunnerReport {

	// private static final Logger LOG = LogManager.getLogger(RunnerReport.class);
	public static final String HORIZONTAL_LINE = "============================================================";
	public static final String HEADER_FORMAT = "%4s %4s %4s %7s %9s %11s %8s %6s%n";
	public static final String RUNNER_FORMAT = "%4d %4d %4d %7s %9s %11s %8.3f %6.3f%n";

	public static void write(Collection<Runner> sortedRunners) throws ApplicationException {
		System.out.println(HORIZONTAL_LINE);
		System.out.format(HEADER_FORMAT, "Rank", "Lane", "Bib#", "Country", "Last Name", "First Name", "Reaction", "Result");
		int rank = 0;
		for (Runner runner : sortedRunners) {
			System.out.format(RUNNER_FORMAT, ++rank, runner.getLane(), runner.getBibNumber(), runner.getCountry(), runner.getLastName(),
					runner.getFirstName(), runner.getReaction(), runner.getResult());
		}
		System.out.println(HORIZONTAL_LINE);
	}

}
