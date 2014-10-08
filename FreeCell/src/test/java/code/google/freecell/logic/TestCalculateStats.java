package code.google.freecell.logic;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import code.google.freecell.data.Stats;

@RunWith(Parameterized.class)
public class TestCalculateStats {

	public FreeCellCalculator calculator;

	private int n;
	private int percentage;
	private Stats expected;

	@Before
	public void initialize() {
		calculator = new FreeCellCalculator();
	}

	@Parameterized.Parameters
	public static Collection primeNumbers() {
		return Arrays.asList(new Object[][] { { 10, 10, new Stats(10, 1, 9) },
				{ 100, 15, new Stats(20, 3, 17) },
				{ 8, 60, new Stats(5, 3, 2) } });
	}

	public TestCalculateStats(int n, int percentage, Stats expected) {
		this.n = n;
		this.percentage = percentage;
		this.expected = expected;
	}

	@Test
	public void calculateStats() {
		assertEquals("calculateStats(" + n + ", " + percentage
				+ ") should return " + expected, expected,
				calculator.calculateStats(percentage));
	}
}
