package code.google.killerword.logic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import code.google.killerword.data.Clause;
import static org.junit.Assert.*;

public class TestClausePartitioner {

	public static ClausePartitioner partitioner;

	@BeforeClass
	public static void createClausePartitioner() {
		partitioner = new ClausePartitioner();
	}

	@Test
	public void buildPatternShouldNotChangePatternOnEmptyPositionsSet() {
		String pattern = "...xy";
		Set<Integer> positions = new HashSet<Integer>(
				Arrays.asList(new Integer[] {}));
		assertEquals(
				"ClausePartitioner.buildPattern() should not change pattern on empty positions set.",
				"...xy", partitioner.buildPattern(pattern, positions, 'a'));
	}

	@Test
	public void buildPatternShouldReplaceDotsAtSpecificPositions() {
		String pattern = "...xy";
		Set<Integer> positions = new HashSet<Integer>(
				Arrays.asList(new Integer[] { 0, 1, 2 }));
		assertEquals(
				"ClausePartitioner.buildPattern() should replace dots at specific positions.",
				"aaaxy", partitioner.buildPattern(pattern, positions, 'a'));
	}

	@Test
	public void buildPatternShouldNotReplaceCharactersOtherThanDots() {
		String pattern = "...xy";
		Set<Integer> positions = new HashSet<Integer>(
				Arrays.asList(new Integer[] { 2, 3, 4 }));
		assertEquals(
				"ClausePartitioner.buildPattern() should not replace characters.",
				"..axy", partitioner.buildPattern(pattern, positions, 'a'));
	}

	@Test
	public void createNewClauseShouldIncrementLostPointsOnEmptyPositions() {
		String pattern = "a..";
		Set<String> words = new HashSet<>(Arrays.asList(new String[] { "abb",
				"abc" }));
		Set<Integer> positions = new HashSet<>(Arrays.asList(new Integer[] {}));
		Set<Character> chars = new HashSet<>(Arrays.asList(new Character[] {
				'a', 'b' }));
		Clause newClause = partitioner.createNewClause(pattern, positions,
				words, 0);
		assertEquals(
				"ClausePartitioner.createNewClause() should increment lost points on empty positions.",
				1, newClause.getLostPoints());
	}

	@Test
	public void createNewClauseShouldNotIncrementLostPointsOnNonEmptyPositions() {
		String pattern = "a..";
		Set<String> words = new HashSet<>(Arrays.asList(new String[] { "abb",
				"abc" }));
		Set<Integer> positions = new HashSet<>(
				Arrays.asList(new Integer[] { 2 }));
		Set<Character> chars = new HashSet<>(Arrays.asList(new Character[] {
				'a', 'b' }));
		Clause newClause = partitioner.createNewClause(pattern, positions,
				words, 0);
		assertEquals(
				"ClausePartitioner.createNewClause() should increment lost points on empty positions.",
				0, newClause.getLostPoints());
	}
}
