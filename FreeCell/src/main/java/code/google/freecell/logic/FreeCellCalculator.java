package code.google.freecell.logic;

import code.google.freecell.data.Stats;

public class FreeCellCalculator {

	public int greatestCommonDivisor(int a, int b) {
		if (a > b) {
			return gcd(a, b);
		}
		if (a < b) {
			return gcd(b, a);
		}
		return a;
	}

	private int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);

	}

	public Stats calculateStats(int percentage) {
		int gcd = greatestCommonDivisor(100, percentage);
		int games = 100 / gcd;
		int wins = percentage / gcd;
		int losses = games - wins;

		return new Stats(games, wins, losses);
	}

}
