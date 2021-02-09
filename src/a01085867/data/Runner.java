/**
 * Project: A01085867_Lab8
 * File: Athletes.java
 * Date: Nov. 14, 2020
 * Time: 6:44:31 p.m.
 */
package a01085867.data;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

/**
 * @author Kelvin Musodza, A01085867
 *
 */
public class Runner extends Thread {

	public static final int FIELDS = 6;
	public static final int RACE_LENGHT = 100;

	private String firstName;
	private String lastName;
	private String country;
	private int bibNumber;
	private int lane;
	private double reaction;
	private double result;

	public static class Builder {
		// Required parameters
		private int bibNumber;

		// Optional parameters
		private String firstName;
		private String lastName;
		private String country;
		private int lane;
		private double reaction;
		private double result;

		public Builder(int bibNumber) {
			this.bibNumber = bibNumber;
		}

		public Builder firstName(String val) {
			firstName = val;
			return this;
		}

		public Builder lastName(String val) {
			lastName = val;
			return this;
		}

		public Builder country(String val) {
			country = val;
			return this;
		}

		public Builder reaction(double val) {
			reaction = val;
			return this;
		}

		public Builder lane(int val) {
			lane = val;
			return this;
		}

		public Builder result(double val) {
			result = val;
			return this;
		}

		public Runner build() {
			return new Runner(this);
		}
	}

	private Runner(Builder builder) {
		firstName = builder.firstName;
		lastName = builder.lastName;
		reaction = builder.reaction;
		country = builder.country;
		bibNumber = builder.bibNumber;
		lane = builder.lane;
		result = builder.result;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @return the bibNumber
	 */
	public int getBibNumber() {
		return bibNumber;
	}

	/**
	 * @return the lane
	 */
	public int getLane() {
		return lane;
	}

	/**
	 * @return the reaction
	 */
	public double getReaction() {
		return reaction;
	}

	/**
	 * @return the result
	 */
	public double getResult() {
		return result;
	}

	@Override
	public void run() {
		Instant startTime = Instant.now();
		Random randomDelay = new Random();
		try {
			for (int i = 0; i < RACE_LENGHT; i++) {
				sleep(93 + randomDelay.nextInt(10));
			}
		} catch (InterruptedException e) {
		} finally {
			Instant endTime = Instant.now();
			result = (((double) (Duration.between(startTime, endTime).toMillis())) / 1000) + reaction;
		}
	}

	public void RaceThread(Runner runner) {

		setName(String.valueOf(runner.getBibNumber()) + " - " + runner.getFirstName() + " " + runner.getLastName());
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @param bibNumber
	 *            the bibNumber to set
	 */
	public void setBibNumber(int bibNumber) {
		this.bibNumber = bibNumber;
	}

	/**
	 * @param lane
	 *            the lane to set
	 */
	public void setLane(int lane) {
		this.lane = lane;
	}

	/**
	 * @param reaction
	 *            the reaction to set
	 */
	public void setReaction(double reaction) {
		this.reaction = reaction;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public void setResult(double result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Runner [firstName=" + firstName + ", lastName=" + lastName + ", country=" + country + ", bibNumber=" + bibNumber + ", lane=" + lane
				+ ", reaction=" + reaction + ", result=" + result + "]";
	}

}
