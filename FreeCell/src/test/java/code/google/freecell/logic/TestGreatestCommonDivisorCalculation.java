package code.google.freecell.logic;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestGreatestCommonDivisorCalculation {

	public FreeCellCalculator calculator;

	private int a;
	private int b;
	private int expected;

	@Before
	public void initialize() {
		calculator = new FreeCellCalculator();
	}

	@Parameterized.Parameters
	public static Collection primeNumbers() {
		return Arrays.asList(new Object[][] { { 100, 2, 2 }, { 2, 100, 2 },
				{ 37, 43, 1 }, { 100000, 2000, 2000 }, { 14450, 7150, 50 } });
	}

	public TestGreatestCommonDivisorCalculation(int a, int b, int expected) {
		this.a = a;
		this.b = b;
		this.expected = expected;
	}

	@Test
	public void greatestCommonDivisor() {
		assertEquals("gcd(" + a + ", " + b + ") should be " + expected,
				expected, calculator.greatestCommonDivisor(a, b));
	}
}
