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

public class TestClauseCalculator {
	public static ClauseCalculator calculator;

	@BeforeClass
	public static void createClausePartitioner() {
		calculator = new ClauseCalculator();
	}

	@Test
	public void buildCharacterSetShouldContainOnlyAndAllCharsInWords() {
		Set<String> words = new HashSet<>();
		words.add("abc");
		words.add("cee");
		words.add("dfa");
		words.add("axy");

		Set<Character> expected = new HashSet<Character>(
				Arrays.asList(new Character[] { 'a', 'b', 'c', 'd', 'e', 'f',
						'x', 'y' }));

		assertEquals(
				"ClauseCalculator.buildCharacterSetForWords() should create character set "
						+ "form all and only characters contained by words.",
				expected, calculator.buildCharacterSetForWords(words));
	}

	@Test
	public void buildWordsLengthMapShouldReturnSpecifiedMap() {
		Set<String> words = new HashSet<>();
		words.add("abc");
		words.add("abcd");
		words.add("befa");
		words.add("abcxyz");
		words.add("xyzabc");

		Map<Integer, Set<String>> expected = new HashMap<>();
		expected.put(3,
				new HashSet<String>(Arrays.asList(new String[] { "abc" })));
		expected.put(
				4,
				new HashSet<String>(Arrays
						.asList(new String[] { "abcd", "befa" })));
		expected.put(
				6,
				new HashSet<String>(Arrays.asList(new String[] { "abcxyz",
						"xyzabc" })));

		assertEquals(
				"ClauseCalculator.buildCharacterSetForWords() should create character set "
						+ "form all and only characters contained by words.",
				expected,
				calculator.buildWordsByLengthMap(new InputData(words, null)));
	}

	@Test
	public void extractFinishedShouldReturnSetOfFinishedClauses() {
		Set<Clause> clauses = new HashSet<>();

		Clause clause1 = new Clause();
		clause1.addWord("aa");
		clauses.add(clause1);

		Clause clause2 = new Clause();
		clause2 = new Clause();
		clause2.addWord("aab");
		clause2.addWord("aac");
		clauses.add(clause2);

		Clause clause3 = new Clause();
		clause3.addWord("baba");
		clauses.add(clause3);

		Clause clause4 = new Clause();
		clause4.addWord("bbabab");
		clause4.addWord("babbba");
		clauses.add(clause4);

		Set<Clause> finished = calculator.extractFinished(clauses);

		assertTrue(
				"extractFinished() should return set which contains all finished clauses, and nothing else.",
				finished.contains(clause1) && finished.contains(clause3)
						&& !finished.contains(clause2)
						&& !finished.contains(clause4));
	}

	@Test
	public void extractFinishedShouldExtractFinishedClauses() {
		Set<Clause> clauses = new HashSet<>();

		Clause clause1 = new Clause();
		clause1.addWord("aa");
		clauses.add(clause1);

		Clause clause2 = new Clause();
		clause2 = new Clause();
		clause2.addWord("aab");
		clause2.addWord("aac");
		clauses.add(clause2);

		Clause clause3 = new Clause();
		clause3.addWord("baba");
		clauses.add(clause3);

		Clause clause4 = new Clause();
		clause4.addWord("bbabab");
		clause4.addWord("babbba");
		clauses.add(clause4);

		calculator.extractFinished(clauses);

		assertTrue(
				"extractFinished() should return set which contains all finished clauses, and nothing else.",
				!clauses.contains(clause1) && !clauses.contains(clause3)
						&& clauses.contains(clause2)
						&& clauses.contains(clause4));
	}

	@Test
	public void extractMaxLostPointsShouldNotModifyMaxSetIfThereIsNotBetterClause() {
		Set<Clause> clauses = new HashSet<>();

		Clause clause1 = new Clause();
		clause1.addWord("aa");
		clause1.setLostPoints(1);
		clauses.add(clause1);

		Clause clause2 = new Clause();
		clause2 = new Clause();
		clause2.addWord("aab");
		clause2.setLostPoints(2);
		clauses.add(clause2);

		Clause clause3 = new Clause();
		clause3.addWord("baba");
		clause3.setLostPoints(2);
		clauses.add(clause3);

		Clause clause4 = new Clause();
		clause4.addWord("bbabab");
		clause4.setLostPoints(3);
		clauses.add(clause4);

		Clause clause5 = new Clause();
		clause5.addWord("baabab");
		clause5.setLostPoints(2);
		clauses.add(clause5);

		Set<Clause> maxSet = new HashSet<Clause>();
		maxSet.add(clause4);
		calculator.extractMaxLostPointClauses(clauses, maxSet, 5);

		assertTrue(
				"extractFinished() should not modify max set if there is not better clause.",
				maxSet.size() == 1 && maxSet.contains(clause4));
	}

	@Test
	public void extractMaxLostPointsShouldReturnParameterIfThereIsNoBetterClause() {
		Set<Clause> clauses = new HashSet<>();

		Clause clause1 = new Clause();
		clause1.addWord("aa");
		clause1.setLostPoints(1);
		clauses.add(clause1);

		Clause clause2 = new Clause();
		clause2 = new Clause();
		clause2.addWord("aab");
		clause2.setLostPoints(2);
		clauses.add(clause2);

		Clause clause3 = new Clause();
		clause3.addWord("baba");
		clause3.setLostPoints(2);
		clauses.add(clause3);

		Clause clause4 = new Clause();
		clause4.addWord("bbabab");
		clause4.setLostPoints(3);
		clauses.add(clause4);

		Clause clause5 = new Clause();
		clause5.addWord("baabab");
		clause5.setLostPoints(2);
		clauses.add(clause5);

		Set<Clause> maxSet = new HashSet<Clause>();
		maxSet.add(clause4);
		int max = calculator.extractMaxLostPointClauses(clauses, maxSet, 5);

		assertEquals(
				"extractFinished() return max value added in parameter, if there is no better clause.",
				max, 5);
	}

	@Test
	public void extractMaxLostPointsShouldModifyMaxSetIfThereIsBetterClause() {
		Set<Clause> clauses = new HashSet<>();

		Clause clause1 = new Clause();
		clause1.addWord("aa");
		clause1.setLostPoints(1);
		clauses.add(clause1);

		Clause clause2 = new Clause();
		clause2 = new Clause();
		clause2.addWord("aab");
		clause2.setLostPoints(2);
		clauses.add(clause2);

		Clause clause3 = new Clause();
		clause3.addWord("baba");
		clause3.setLostPoints(2);
		clauses.add(clause3);

		Clause clause4 = new Clause();
		clause4.addWord("bbabab");
		clause4.setLostPoints(3);
		clauses.add(clause4);

		Clause clause5 = new Clause();
		clause5.addWord("baabab");
		clause5.setLostPoints(2);
		clauses.add(clause5);

		Set<Clause> maxSet = new HashSet<Clause>();
		maxSet.add(clause1);
		calculator.extractMaxLostPointClauses(clauses, maxSet, 0);

		assertTrue(
				"extractFinished() should modify max set if there is better clause.",
				maxSet.size() == 1 && maxSet.contains(clause4));
	}
}
