package code.google.killerword.logic;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import code.google.killerword.data.Clause;

public class TestPositionSetForClause {

	@Test
	public void fullPositionSetsShouldBeReturnedOnEmtpyPattern() {
		ClausePartitioner partitioner = new ClausePartitioner();

		Clause clause = new Clause();
		clause.setPattern("....");
		clause.addWord("abba");
		clause.addWord("baba");
		clause.addWord("bbab");
		clause.addWord("aaab");

		Set<Set<Integer>> expected = new HashSet<>();

		Set<Integer> positionSet;
		positionSet = new HashSet<>();
		positionSet.add(0);
		positionSet.add(3);
		expected.add(positionSet);
		positionSet = new HashSet<>();
		positionSet.add(1);
		positionSet.add(3);
		expected.add(positionSet);
		positionSet = new HashSet<>();
		positionSet.add(2);
		expected.add(positionSet);
		positionSet = new HashSet<>();
		positionSet.add(0);
		positionSet.add(1);
		positionSet.add(2);
		expected.add(positionSet);

		assertEquals("Full position sets should be retorned on pattern '....'",
				expected, partitioner.calculatePositionSets(clause, 'a'));
	}

	@Test
	public void partialPositionSetsShouldBeRetrnedOnNonEmptyPattern() {
		ClausePartitioner partitioner = new ClausePartitioner();

		Clause clause = new Clause();
		clause.setPattern("a..a");
		clause.addWord("abba");
		clause.addWord("baba");
		clause.addWord("bbab");
		clause.addWord("aaab");

		Set<Set<Integer>> expected = new HashSet<>();

		Set<Integer> positionSet;
		positionSet = new HashSet<>();
		expected.add(positionSet);
		positionSet = new HashSet<>();
		positionSet.add(1);
		expected.add(positionSet);
		positionSet = new HashSet<>();
		positionSet.add(2);
		expected.add(positionSet);
		positionSet = new HashSet<>();
		positionSet.add(1);
		positionSet.add(2);
		expected.add(positionSet);

		assertEquals(
				"Partial position sets should be returned on pattern 'a..a'",
				expected, partitioner.calculatePositionSets(clause, 'a'));
	}

	@Test
	public void emptyPositionSetShouldBeReturnedIfCharIsNotInWords() {
		ClausePartitioner partitioner = new ClausePartitioner();

		Clause clause = new Clause();
		clause.setPattern("a...");
		clause.addWord("abba");
		clause.addWord("baba");
		clause.addWord("bbab");
		clause.addWord("aaab");

		Set<Set<Integer>> expected = new HashSet<>();

		Set<Integer> positionSet;
		positionSet = new HashSet<>();
		expected.add(positionSet);

		assertEquals(
				"Empy position sets should be returned in char is not in words ('x').",
				expected, partitioner.calculatePositionSets(clause, 'x'));
	}
}
