package code.google.candy.logic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestCandyCalculator {

	@Test
	public void xorSumShouldReturnSpecificValue1() {
		CandyCalculator calculator = new CandyCalculator();
		List<Integer> numbers = new ArrayList<>();
		numbers.add(15);
		numbers.add(7);

		assertEquals("XOR[15,7] should be 8.", 8, calculator.xorSum(numbers));
	}

	@Test
	public void xorSumShouldReturnSpecificValue2() {
		CandyCalculator calculator = new CandyCalculator();
		List<Integer> numbers = new ArrayList<>();
		numbers.add(31);
		numbers.add(16);
		numbers.add(8);
		numbers.add(1);

		assertEquals("XOR[31,16,8,1] should be 6.", 6,
				calculator.xorSum(numbers));
	}

	@Test
	public void xorSumShouldReturnSpecificValue3() {
		CandyCalculator calculator = new CandyCalculator();
		List<Integer> numbers = new ArrayList<>();
		numbers.add(128);
		numbers.add(64);
		numbers.add(1);
		numbers.add(3);

		assertEquals("XOR[128,64,3,1] should be 194.", 194,
				calculator.xorSum(numbers));
	}

	@Test
	public void xorSumListsShouldReturnSpecificValue() {
		CandyCalculator calculator = new CandyCalculator();
		List<Integer> numbers1 = new ArrayList<>();
		numbers1.add(31);
		numbers1.add(16);
		List<Integer> numbers2 = new ArrayList<>();
		numbers2.add(3);
		numbers2.add(4);
		numbers2.add(8);

		assertEquals("[31,16] XOR [8,4,3] should be 0.", 0,
				calculator.xorSum(numbers1, numbers2));
	}

	@Test
	public void sumShouldReturnSpecificValue() {
		CandyCalculator calculator = new CandyCalculator();
		List<Integer> numbers = new ArrayList<>();
		numbers.add(2);
		numbers.add(8);
		numbers.add(100);

		assertEquals("SUM[100,8,2] should be 0.", 110, calculator.sum(numbers));
	}

	public void removeMinShouldRemoveSmallestUmberFromList() {
		CandyCalculator calculator = new CandyCalculator();
		List<Integer> numbers = new ArrayList<>();
		numbers.add(2);
		numbers.add(3);
		numbers.add(1);
		numbers.add(4);

		List<Integer> expected = new ArrayList<>();
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		calculator.removeMin(numbers);

		assertEquals("removeMin() should remove minumum number from list.",
				expected, numbers);
	}
}
