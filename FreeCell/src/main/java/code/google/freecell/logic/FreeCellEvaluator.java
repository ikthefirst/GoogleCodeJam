package code.google.freecell.logic;

import code.google.freecell.data.Stats;

public class FreeCellEvaluator {

	public boolean evaluateDailyStats(int maxGames, Stats dailyStats) {
		return (dailyStats.getNumberOfGames() <= maxGames);
	}

	public boolean evaluateGlobalStats(Stats dailyStats, Stats globalStats) {
		if (dailyStats.getNumberOfGames() > globalStats.getNumberOfGames()) {
			return false;
		}
		if (dailyStats.getNumberOfWin() > globalStats.getNumberOfWin()) {
			return false;
		}
		if (dailyStats.getNumberOfLoss() > globalStats.getNumberOfLoss()) {
			return false;
		}

		return true;
	}

}
