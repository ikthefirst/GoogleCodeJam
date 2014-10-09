package code.google.killerword;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import code.google.killerword.data.Clause;
import code.google.killerword.data.InputData;
import code.google.killerword.logic.ClauseCalculator;
import code.google.killerword.logic.ClauseEvaluator;
import code.google.skeleton.AbstractApplication;
import code.google.skeleton.AbstractParser;

public class Application extends AbstractApplication<InputData> {

	@Override
	public AbstractParser<InputData> createParser() {
		return new Parser();
	}

	@Override
	public void doStuff(List<InputData> inputDatas) {
		int testcaseNum = 0;
		for (InputData inputData : inputDatas) {
			testcaseNum++;
			ClauseCalculator calculator = new ClauseCalculator();
			ClauseEvaluator evaluator = new ClauseEvaluator();

			Map<Integer, Clause> clauses = calculator
					.initializeClauses(inputData);

			List<String> result = new ArrayList<>();
			for (String trial : inputData.getTrials()) {
				Set<String> killerWords = evaluator.determineKillerWords(trial,
						clauses);
				result.add(evaluator.getFirstWord(inputData.getDictionary(),
						killerWords));
			}

			printResult(testcaseNum, result);
		}
	}

	private void printResult(int n, List<String> result) {
		System.out.print("Case #" + n + ": ");
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i));
			if (i < result.size() - 1) {
				System.out.print(" ");
			}
		}
		System.out.println();
	}
}
