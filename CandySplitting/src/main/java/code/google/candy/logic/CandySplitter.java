package code.google.candy.logic;

import java.util.List;

public class CandySplitter {

	private CandyCalculator calculator;

	public boolean isSplittable(List<Integer> candies) {
		return calculator.xorSum(candies) == 0;
	}

	public List<Integer> doSplit(List<Integer> candies) {
		return calculator.removeMin(candies);
	}

	public int calculatePile(List<Integer> candies) {
		return calculator.sum(candies);
	}

	public CandyCalculator getCalculator() {
		return calculator;
	}

	public void setCalculator(CandyCalculator calculator) {
		this.calculator = calculator;
	}

}
