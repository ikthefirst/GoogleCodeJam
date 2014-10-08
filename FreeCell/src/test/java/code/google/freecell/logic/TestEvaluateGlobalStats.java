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
public class TestEvaluateGlobalStats {

	public FreeCellEvaluator evaluator;

	private Stats dailyStats;
	private Stats globalStats;
	private boolean expected;

	@Before
	public void initialize() {
		evaluator = new FreeCellEvaluator();
	}

	@Parameterized.Parameters
	public static Collection primeNumbers() {
		return Arrays.asList(new Object[][] {
				{ new Stats(10, 5, 5), new Stats(9, 5, 5), false },
				{ new Stats(10, 5, 5), new Stats(20, 4, 6), false },
				{ new Stats(10, 5, 5), new Stats(20, 6, 4), false },
				{ new Stats(10, 2, 8), new Stats(100, 3, 97), true },
				{ new Stats(1, 1, 0), new Stats(2, 1, 1), true }, });
	}

	public TestEvaluateGlobalStats(Stats dailyStats, Stats globalStats,
			boolean expected) {
		this.dailyStats = dailyStats;
		this.globalStats = globalStats;
		this.expected = expected;
	}

	@Test
	public void calculateStats() {
		assertEquals("evaluateGlobalStats(" + dailyStats + ", " + globalStats
				+ ") should return " + expected, expected,
				evaluator.evaluateGlobalStats(dailyStats, globalStats));
	}
}
