package code.google.freecell.logic;

import code.google.freecell.data.InputData;
import code.google.freecell.data.Stats;

public class FreeCellEvaluator {

	public boolean evaluateInput(InputData inputData) {
		int Pd = inputData.getWinPercentageToday();
		int Pg = inputData.getWinPercentageTotal();

		if (Pd < 0 || Pd > 100) {
			return false;
		}

		if (Pg < 0 || Pg > 100) {
			return false;
		}

		if (Pd != 0 && Pg == 0) {
			return false;
		}

		if (Pd != 100 && Pg == 100) {
			return false;
		}

		return true;
	}

	public boolean evaluateDailyStats(long maxGames, Stats dailyStats) {
		return (dailyStats.getNumberOfGames() <= maxGames);
	}

	public boolean evaluateGlobalStats(Stats dailyStats, Stats globalStats) {
		if (dailyStats.getNumberOfGames() > globalStats.getNumberOfGames()) {
			return false;
		}
		if (dailyStats.getNumberOfWins() > globalStats.getNumberOfWins()) {
			return false;
		}
		if (dailyStats.getNumberOfLoss() > globalStats.getNumberOfLoss()) {
			return false;
		}

		return true;
	}

}
