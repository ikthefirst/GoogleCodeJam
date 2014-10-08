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

			Stats dailyStats = calculator.calculateStats(inputData
					.getWinPercentageToday());
			Stats globalStats = calculator.calculateStats(inputData
					.getWinPercentageTotal());

			boolean result = evaluator.evaluateDailyStats(
					inputData.getMaxGamesToday(), dailyStats)
					&& evaluator.evaluateGlobalStats(dailyStats, globalStats);

			printResult(testcaseNum, result);
		}
	}

	private void printResult(int n, Object result) {
		System.out.println("Case #" + n + ": " + result);
	}

}
