package code.google.killerword.logic;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import static org.junit.Assert.*;
import code.google.killerword.data.Clause;

public class TestClausePartitionerPartition {

	@Test
	public void specificNumberOfPartitionsShouldBeCreatedIfWordsContainGivenCharacter() {
		String pattern = "....";
		Set<String> words = new HashSet<>();
		words.add("abba");
		words.add("baba");
		words.add("babb");
		words.add("aaba");
		Clause clause = new Clause(pattern, words, 0);

		ClausePartitioner partitioner = new ClausePartitioner();
		Set<Clause> newClauses = partitioner.partition(clause, 'a');

		assertEquals(
				"partition(clause, 'a') should create 4 clause if the clause is: '....'[abba, baba, babb, aaba].",
				4, newClauses.size());
	}

	@Test
	public void noNewPartitionShouldBeCreatedIfWordsNotContainGivenCharacter() {
		String pattern = "....";
		Set<String> words = new HashSet<>();
		words.add("abba");
		words.add("baba");
		words.add("babb");
		words.add("aaba");
		Clause clause = new Clause(pattern, words, 0);

		ClausePartitioner partitioner = new ClausePartitioner();
		Set<Clause> newClauses = partitioner.partition(clause, 'c');

		assertEquals(
				"Partition should not create new clause if the character is not container by the words in the clause.",
				1, newClauses.size());
	}

	@Test
	public void sizeOfWordsInNewClausesShouldBeAtLeastOne() {
		ClausePartitioner partitioner = new ClausePartitioner();

		Clause clause = new Clause();
		clause.setPattern("....");
		clause.addWord("abba");
		clause.addWord("baba");
		clause.addWord("bbab");
		clause.addWord("aaab");
		clause.addWord("aaac");
		clause.addWord("acca");
		clause.addWord("abca");
		clause.addWord("acba");
		clause.addWord("bbbb");

		Set<Clause> newClauses = partitioner.partition(clause, 'a');
		// System.out.println(newClauses);

		for (Clause c : newClauses) {
			assertTrue("Size of words should be greater than zero in " + c, c
					.getWords().size() > 0);
		}
	}

	@Test
	public void lostWordsShouldIncrementInClauseWhichNotContainCharacter() {
		ClausePartitioner partitioner = new ClausePartitioner();

		Clause clause = new Clause();
		clause.setPattern("....");
		clause.addWord("abba");
		clause.addWord("baba");
		clause.addWord("bbab");
		clause.addWord("aaab");
		clause.addWord("aaac");
		clause.addWord("acca");
		clause.addWord("abca");
		clause.addWord("acba");

		Set<Clause> newClauses = partitioner.partition(clause, 'c');

		for (Clause c : newClauses) {
			assertTrue("Size of words should be greater than zero in " + c, c
					.getWords().size() > 0);
		}
	}

	@Test
	public void specificClausesHasToBeCreated() {
		ClausePartitioner partitioner = new ClausePartitioner();

		Clause clause = new Clause();
		clause.setPattern(".a.a.a.");
		clause.addWord("pajamas");
		clause.addWord("caravan");

		Set<Clause> newClauses = partitioner.partition(clause, 'c');
		System.out.println(newClauses);

		assertEquals(
				"Specific clauses has to be created, clause size should be 2.",
				2, newClauses.size());
	}
}
