package code.google.freecell;

import java.util.List;

import code.google.freecell.data.InputData;
import code.google.freecell.data.Stats;
import code.google.freecell.logic.FreeCellCalculator;
import code.google.freecell.logic.FreeCellEvaluator;
import code.google.freecell.skeleton.AbstractApplication;
import code.google.freecell.skeleton.AbstractParser;

public class Application extends AbstractApplication<InputData> {

	@Override
	public AbstractParser<InputData> createParser() {
		return new Parser();
	}

	@Override
	public void doStuff(List<InputData> inputDatas) {
		FreeCellCalculator calculator = new FreeCellCalculator();
		FreeCellEvaluator evaluator = new FreeCellEvaluator();

		int testcaseNum = 0;
		for (InputData inputData : inputDatas) {
			testcaseNum++;

			if (!evaluator.evaluateInput(inputData)) {
				printResult(testcaseNum, false);
				continue;
			}

			Stats dailyStats = calculator.calculateStats(inputData
					.getWinPercentageToday());

			if (!evaluator.evaluateDailyStats(inputData.getMaxGamesToday(),
					dailyStats)) {
				printResult(testcaseNum, false);
				continue;
			}

			Stats globalStats = calculator.calculateStats(inputData
					.getWinPercentageTotal());

			// not needed.
			// if (!evaluator.evaluateGlobalStats(dailyStats, globalStats)) {
			// printResult(testcaseNum, false);
			// continue;
			// }

			printResult(testcaseNum, true);
		}
	}

	private void printResult(int n, boolean result) {
		System.out.println("Case #" + n + ": "
				+ (result ? "Possible" : "Broken"));
	}

}
