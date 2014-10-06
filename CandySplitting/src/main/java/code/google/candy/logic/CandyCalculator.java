package code.google.candy.logic;

import java.util.ArrayList;
import java.util.Iterator;
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

	public List<Integer> removeMin(List<Integer> numbers) {
		if (numbers.size() <= 0) {
			return new ArrayList<Integer>();
		}
		int minIdx = 0;
		int min = numbers.get(minIdx);
		for (int i = 1; i < numbers.size(); i++) {
			int number = numbers.get(i);
			if (number < min) {
				min = number;
				minIdx = i;
			}
		}
		numbers.remove(minIdx);

		return numbers;
	}
}
