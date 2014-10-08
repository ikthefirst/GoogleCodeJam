package code.google.killerword.logic;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import static org.junit.Assert.*;

import code.google.killerword.data.Clause;

public class TestClausePartitionerWithoutPosition {

	@Test
	public void partitionedSizeBeGreaterThanOneIfTheCharacterIsContainedByTheClause() {
		String pattern = "....";
		Set<String> words = new HashSet<>();
		words.add("abba");
		words.add("baba");
		words.add("babb");
		words.add("aaba");
		Clause clause = new Clause(pattern, words, 0);
		clause.addCharacter('a');
		clause.addCharacter('b');

		ClausePartitioner partitioner = new ClausePartitioner();
		Set<Clause> newClauses = partitioner.partition(clause, 'a');

		assertEquals(
				"partition(clause, 'a') should create 4 clause if the clause is: '....'[abba, baba, babb, aaba].",
				4, newClauses.size());
	}

	@Test
	public void partitionedSizeShouldBeOneIfTheCharacterIsNotContainedByTheClause() {
		String pattern = "....";
		Set<String> words = new HashSet<>();
		words.add("abba");
		words.add("baba");
		words.add("babb");
		words.add("aaba");
		Clause clause = new Clause(pattern, words, 0);
		clause.addCharacter('a');
		clause.addCharacter('b');

		ClausePartitioner partitioner = new ClausePartitioner();
		Set<Clause> newClauses = partitioner.partition(clause, 'c');

		assertEquals(
				"Partition should not create new clause if the character is not container by the words in the clause.",
				1, newClauses.size());
	}

	@Test
	public void lostPointsInClauseShouldIncrementByOneIfCanNotBePartitioned() {
		String pattern = "....x";
		Set<String> words = new HashSet<>();
		words.add("ybbax");
		words.add("babax");
		words.add("babbx");
		words.add("aabax");
		Clause clause = new Clause(pattern, words, 10);
		clause.addCharacter('a');
		clause.addCharacter('b');
		clause.addCharacter('y');

		ClausePartitioner partitioner = new ClausePartitioner();
		Set<Clause> newClauses = partitioner.partition(clause, 'y');

		assertEquals(
				"Lost points in clause should increment by one if contains given character and can not be partitioned.",
				11, clause.getLostPoints());
	}

	@Test
	public void lostPointsInClauseShouldNotIncrementNotContainsGivenCharacter() {
		String pattern = "....x";
		Set<String> words = new HashSet<>();
		words.add("abbax");
		words.add("babax");
		words.add("babbx");
		words.add("aabax");
		Clause clause = new Clause(pattern, words, 45);
		clause.addCharacter('a');
		clause.addCharacter('b');

		ClausePartitioner partitioner = new ClausePartitioner();
		Set<Clause> newClauses = partitioner.partition(clause, 'y');

		assertEquals(
				"Lost points in clause not should increment if not contains given character.",
				45, clause.getLostPoints());
	}

	@Test
	public void characterShouldBeRemovedFromClausesAfterPartition() {
		String pattern = "....x";
		Set<String> words = new HashSet<>();
		words.add("abbax");
		words.add("babax");
		words.add("babbx");
		words.add("aabax");
		Clause clause = new Clause(pattern, words, 2);
		clause.addCharacter('a');
		clause.addCharacter('b');

		ClausePartitioner partitioner = new ClausePartitioner();
		Set<Clause> newClauses = partitioner.partition(clause, 'a');

		for (Clause c : newClauses) {
			assertFalse("", c.getContainedCharacters().contains('a'));
		}
	}

}
