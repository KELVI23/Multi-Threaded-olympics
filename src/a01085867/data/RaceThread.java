package a01085867.data;

public class RaceThread extends Thread {

	private Runner runner;

	public RaceThread(Runner runner) {
		this.runner = runner;
		setName(String.valueOf(runner.getBibNumber()) + " - " + runner.getFirstName() + " " + runner.getLastName());
	}

	@Override
	public void run() {
		runner.run();
	}
}
