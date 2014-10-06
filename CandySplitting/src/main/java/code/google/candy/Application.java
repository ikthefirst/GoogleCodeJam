package code.google.candy;

import java.util.List;

import code.google.candy.logic.CandyCalculator;
import code.google.candy.logic.CandySplitter;
import code.google.candy.skeleton.AbstractApplication;
import code.google.candy.skeleton.AbstractParser;

public class Application extends AbstractApplication<List<Integer>> {

	@Override
	public AbstractParser<List<Integer>> createParser() {
		return new Parser();
	}

	@Override
	public void doStuff(List<List<Integer>> inputData) {
		CandyCalculator calculator = new CandyCalculator();
		CandySplitter splitter = new CandySplitter();
		splitter.setCalculator(calculator);

		int testcaseNum = 0;
		for (List<Integer> candies : inputData) {
			testcaseNum++;
			if (!splitter.isSplittable(candies)) {
				printResult(testcaseNum, "NO");
				continue;
			}

			splitter.doSplit(candies);
			Integer sum = splitter.calculatePile(candies);
			printResult(testcaseNum, sum.toString());

		}
	}

	private void printResult(int n, String result) {
		System.out.println("Case #" + n + ": " + result);
	}

}
