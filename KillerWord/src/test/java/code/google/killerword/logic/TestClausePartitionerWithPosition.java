package code.google.killerword.logic;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import code.google.killerword.data.Clause;

public class TestClausePartitionerWithPosition {

	@Test
	public void partitionShouldNotModifyPatternInPassedClause() {
		Clause clause = new Clause();
		clause.setPattern("...");
		clause.addWord("aaa");
		clause.addWord("baa");
		clause.addWord("caa");
		clause.addCharacter('a');
		clause.addCharacter('b');
		clause.addCharacter('c');

		ClausePartitioner partitioner = new ClausePartitioner();
		partitioner.partition(clause, 'a', 0);

		assertEquals(
				"partition() should not modify pattern the passed clause.",
				"...", clause.getPattern());
	}

	@Test
	public void partitionShouldExtractMatchingWordsFromPassedClause() {
		Clause clause = new Clause();
		clause.setPattern("...");
		clause.addWord("aaa");
		clause.addWord("baa");
		clause.addWord("caa");
		clause.addCharacter('a');
		clause.addCharacter('b');
		clause.addCharacter('c');

		Set<String> expectedWords = new HashSet<>();
		expectedWords.add("baa");
		expectedWords.add("caa");

		ClausePartitioner partitioner = new ClausePartitioner();
		partitioner.partition(clause, 'a', 0);

		assertEquals(
				"partition() should extract matching words from passed clause.",
				expectedWords, clause.getWords());
	}

	@Test
	public void partitionShouldNotExtractNotMatchingWordsFromPassedClause() {
		Clause clause = new Clause();
		clause.setPattern("...");
		clause.addWord("aaa");
		clause.addWord("baa");
		clause.addWord("caa");
		clause.addCharacter('a');
		clause.addCharacter('b');
		clause.addCharacter('c');

		Set<String> expectedWords = new HashSet<>();
		expectedWords.add("aaa");
		expectedWords.add("baa");
		expectedWords.add("caa");

		ClausePartitioner partitioner = new ClausePartitioner();
		partitioner.partition(clause, 'x', 0);

		assertEquals(
				"partition() should not extract words from passed clause if there is no match.",
				expectedWords, clause.getWords());
	}

	@Test
	public void partitionShouldReturnNewClauseWithAppropriatePattern() {
		Clause clause = new Clause();
		clause.setPattern("...");
		clause.addWord("aaa");
		clause.addWord("baa");
		clause.addWord("caa");
		clause.addCharacter('a');
		clause.addCharacter('b');
		clause.addCharacter('c');

		ClausePartitioner partitioner = new ClausePartitioner();
		Clause newClause = partitioner.partition(clause, 'a', 0);

		assertEquals(
				"partition() should return clause with pattern appropriate pattern.",
				"a..", newClause.getPattern());
	}

	@Test
	public void partitionShouldReturnNullIfNoWordsContainTheCharAtPosition() {
		Clause clause = new Clause();
		clause.setPattern("...");
		clause.addWord("aaa");
		clause.addWord("baa");
		clause.addWord("caa");
		clause.addCharacter('a');
		clause.addCharacter('b');
		clause.addCharacter('c');

		ClausePartitioner partitioner = new ClausePartitioner();
		Clause newClause = partitioner.partition(clause, 'x', 0);

		assertEquals(
				"partition() should return null because there is no 'x' in position 0 in any of the words in the clause.",
				null, newClause);
	}

	@Test
	public void partitionShouldNotModifyLostPointsInPassedClause() {
		Clause clause = new Clause();
		clause.setPattern("...");
		clause.addWord("aaa");
		clause.addWord("baa");
		clause.addWord("caa");
		clause.addCharacter('a');
		clause.addCharacter('b');
		clause.addCharacter('c');
		clause.setLostPoints(23);

		ClausePartitioner partitioner = new ClausePartitioner();
		partitioner.partition(clause, 'a', 1);

		assertEquals(
				"partition() should not modify lost points in passed clause.",
				clause.getLostPoints(), 23);
	}

	@Test
	public void partitionShouldNotModifyLostPointsInNewClause() {
		Clause clause = new Clause();
		clause.setPattern("...");
		clause.addWord("aaa");
		clause.addWord("baa");
		clause.addWord("caa");
		clause.addCharacter('a');
		clause.addCharacter('b');
		clause.addCharacter('c');
		clause.setLostPoints(23);

		ClausePartitioner partitioner = new ClausePartitioner();
		Clause newClause = partitioner.partition(clause, 'a', 1);

		assertEquals(
				"partition() should not modify lost points in passed clause.",
				newClause.getLostPoints(), 23);
	}

	@Test
	public void partitionShouldNotModifyWordsIfPositionIsGreaterThanWordsLength() {
		Clause clause = new Clause();
		clause.setPattern("...");
		clause.addWord("aaa");
		clause.addWord("baa");
		clause.addWord("caa");
		clause.addCharacter('a');
		clause.addCharacter('b');
		clause.addCharacter('c');
		clause.setLostPoints(23);

		ClausePartitioner partitioner = new ClausePartitioner();
		partitioner.partition(clause, 'a', 3);

		assertEquals(
				"partition() should not modify words in clause if position is greater than words length.",
				clause.getWords().size(), 3);
	}

	@Test
	public void partitionShouldNotModifyWordsIfPositionIsNegative() {
		Clause clause = new Clause();
		clause.setPattern("...");
		clause.addWord("aaa");
		clause.addWord("baa");
		clause.addWord("caa");
		clause.addCharacter('a');
		clause.addCharacter('b');
		clause.addCharacter('c');
		clause.setLostPoints(23);

		ClausePartitioner partitioner = new ClausePartitioner();
		partitioner.partition(clause, 'a', -1);

		assertEquals(
				"partition() should not modify words in clause if position is negative.",
				clause.getWords().size(), 3);
	}

	@Test
	public void partitionShouldNotModifyPatternIfPositionIsGreaterThanWordsLength() {
		Clause clause = new Clause();
		clause.setPattern("...");
		clause.addWord("aaa");
		clause.addWord("baa");
		clause.addWord("caa");
		clause.addCharacter('a');
		clause.addCharacter('b');
		clause.addCharacter('c');
		clause.setLostPoints(23);

		ClausePartitioner partitioner = new ClausePartitioner();
		partitioner.partition(clause, 'a', 3);

		assertEquals(
				"partition() should not modify pattern in clause if position is greater than words length.",
				clause.getPattern(), "...");
	}

	@Test
	public void partitionShouldNotModifyPatternIfPositionIsNegative() {
		Clause clause = new Clause();
		clause.setPattern("...");
		clause.addWord("aaa");
		clause.addWord("baa");
		clause.addWord("caa");
		clause.addCharacter('a');
		clause.addCharacter('b');
		clause.addCharacter('c');
		clause.setLostPoints(23);

		ClausePartitioner partitioner = new ClausePartitioner();
		partitioner.partition(clause, 'a', -1);

		assertEquals(
				"partition() should not modify pattern in clause if position is negative.",
				clause.getPattern(), "...");
	}

}