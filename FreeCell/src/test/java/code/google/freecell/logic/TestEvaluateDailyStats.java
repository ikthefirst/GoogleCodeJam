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
public class TestEvaluateDailyStats {

	public FreeCellEvaluator evaluator;

	private int n;
	private Stats stats;
	private boolean expected;

	@Before
	public void initialize() {
		evaluator = new FreeCellEvaluator();
	}

	@Parameterized.Parameters
	public static Collection primeNumbers() {
		return Arrays.asList(new Object[][] {
				{ 10, new Stats(10, 1, 9), true },
				{ 10, new Stats(20, 3, 17), false },
				{ 1, new Stats(5, 3, 2), false } });
	}

	public TestEvaluateDailyStats(int n, Stats dailyStats, boolean expected) {
		this.n = n;
		this.stats = dailyStats;
		this.expected = expected;
	}

	@Test
	public void calculateStats() {
		assertEquals("evaluateDailyStats(" + n + ", " + stats
				+ ") should return " + expected, expected,
				evaluator.evaluateDailyStats(n, stats));
	}
}
