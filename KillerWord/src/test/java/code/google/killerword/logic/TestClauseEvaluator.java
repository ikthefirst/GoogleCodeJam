package code.google.killerword.logic;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import code.google.killerword.data.Clause;
import code.google.killerword.data.InputData;

public class TestClauseEvaluator {

	@Test
	public void determineKillerWords1() {
		ClauseEvaluator evaluator = new ClauseEvaluator();

		Set<String> words = new HashSet<String>(Arrays.asList(new String[] {
				"abbab", "abcac", "abdad" }));
		String trial = "abcd";
		Clause clause = new Clause(".....", words, 0);
		Map<Integer, Clause> clauses = new HashMap<Integer, Clause>();
		clauses.put(5, clause);

		Set<String> killerWords = evaluator
				.determineKillerWords(trial, clauses);
		Set<String> expected = new HashSet<String>();
		expected.add("abdad");

		assertEquals("determineKillerWords(" + clause + ")", expected,
				killerWords);

	}

	@Test
	public void determineKillerWords2() {
		ClauseEvaluator evaluator = new ClauseEvaluator();

		Set<String> words = new HashSet<String>(Arrays.asList(new String[] {
				"pajamas", "caravan" }));
		String trial = "abcdefghijklmnopqrstuvwxyz";
		Clause clause = new Clause(".......", words, 0);
		Map<Integer, Clause> clauses = new HashMap<Integer, Clause>();
		clauses.put(5, clause);

		Set<String> killerWords = evaluator
				.determineKillerWords(trial, clauses);
		Set<String> expected = new HashSet<String>();
		expected.add("pajamas");

		assertEquals("determineKillerWords(" + clause + ")", expected,
				killerWords);

	}
}
