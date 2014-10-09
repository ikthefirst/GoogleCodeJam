package code.google.killerword.logic;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

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
	public void extractFinished() {
		fail("TODO: test extractFinished()");
	}

	@Test
	public void extractMaxLostPoints() {
		fail("TODO: test extractMaxLostPoints()");
	}
}
