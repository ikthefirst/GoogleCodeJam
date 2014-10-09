package code.google.killerword.logic;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import code.google.killerword.data.Clause;
import code.google.killerword.data.InputData;

public class TestClauseCalculatorInitClauses {

	public static ClauseCalculator calculator;
	public InputData inputData;

	@BeforeClass
	public static void createClausePartitioner() {
		calculator = new ClauseCalculator();
	}

	@Before
	public void setUpInputData() {
		inputData = new InputData();
		inputData.addWord("a");
		inputData.addWord("aa");
		inputData.addWord("aaa");
		inputData.addWord("aab");
		inputData.addWord("aba");
		inputData.addWord("abb");
		inputData.addWord("aaaaa");
		inputData.addWord("aaaaaab");
		inputData.addWord("abbaaab");
	}

	@Test
	public void mapKeysetSizeShouldBeEqualWithNumberOfDifferentLengthsInWords() {
		Map<Integer, Clause> clauses = calculator.initializeClauses(inputData);
		assertEquals(
				"Map keyset size should be equal with the number of different lengths in words.",
				5, clauses.keySet().size());
	}

	@Test
	public void mapShouldNotContainEntryForNotExistingLength() {
		Map<Integer, Clause> clauses = calculator.initializeClauses(inputData);
		Clause clause = clauses.get(4);
		assertEquals("Map should not contain clause for length=4.", null,
				clause);
	}

	@Test
	public void wordsSizeInCreatedClauseShouldBeEqualWithNumberOfWordsOfGivenLength() {
		Map<Integer, Clause> clauses = calculator.initializeClauses(inputData);
		Clause clause = clauses.get(3);
		assertEquals(
				"Words size in created clause should be equal with number of words of given length.",
				4, clause.getWords().size());
	}

	@Test
	public void patternShouldBeEmptyInCreatedClauses() {
		Map<Integer, Clause> clauses = calculator.initializeClauses(inputData);
		Clause clause = clauses.get(5);
		assertEquals(
				"Map size should be equal with the number of different lengths in words.",
				".....", clause.getPattern());
	}

	@Test
	public void patternLengthInCreatedClauseShouldMatchWordsLength() {
		Map<Integer, Clause> clauses = calculator.initializeClauses(inputData);
		Clause clause = clauses.get(7);
		assertEquals(
				"Map size should be equal with the number of different lengths in words.",
				7, clause.getPattern().length());
	}

}
