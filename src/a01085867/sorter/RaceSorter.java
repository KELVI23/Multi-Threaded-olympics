package a01085867.sorter;

import java.util.Comparator;

import a01085867.data.Runner;

public class RaceSorter {

	public static class CompareResult implements Comparator<Runner> {

		@Override
		public int compare(Runner r1, Runner r2) {
			return (int) (r1.getResult() * 1000 - r2.getResult() * 1000);
		}
	}
}
