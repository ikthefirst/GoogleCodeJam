package code.google.goro;

import java.util.List;

import code.google.goro.skeleton.AbstractApplication;
import code.google.goro.skeleton.AbstractParser;

public class Application extends AbstractApplication<List<Integer>> {

	@Override
	public AbstractParser<List<Integer>> createParser() {
		return new Parser();
	}

	@Override
	public void doStuff(List<List<Integer>> inputData) {
		int testcaseNum = 0;
		for (List<Integer> array : inputData) {
			testcaseNum++;
			System.out.println("Case #" + testcaseNum + ": "
					+ countNumbersInWrongPosition(array));
		}

	}

	private double countNumbersInWrongPosition(List<Integer> numbers) {
		double n = 0.0;
		for (int i = 0; i < numbers.size(); i++) {
			if (numbers.get(i) != i + 1) {
				n = n + 1.0;
			}
		}
		return n;
	}

}
