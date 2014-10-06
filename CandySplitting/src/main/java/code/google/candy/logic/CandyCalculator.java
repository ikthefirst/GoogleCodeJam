package code.google.candy.logic;

import java.util.List;

public class CandyCalculator {

	public int xorSum(List<Integer> numbers) {
		int result = 0;
		for (int number : numbers) {
			result ^= number;
		}
		return result;
	}

	public int sum(List<Integer> numbers) {
		int result = 0;
		for (int number : numbers) {
			result += number;
		}
		return result;
	}

	public int xorSum(List<Integer> numbers1, List<Integer> numbers2) {
		return xorSum(numbers1) ^ xorSum(numbers2);
	}
}
