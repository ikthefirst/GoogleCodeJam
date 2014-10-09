package code.google.killerword.logic;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class TestClausePartitionerMapBuilder {

	@Test
	public void fullPartitionMapShouldBeReturnedOnEmtpyPattern() {
		ClausePartitioner partitioner = new ClausePartitioner();

		String pattern = "....";
		Set<String> words = new HashSet<String>();
		words.add("abba");
		words.add("baba");
		words.add("bbab");
		words.add("aaab");
		words.add("aaac");
		words.add("acca");
		words.add("abca");
		words.add("acba");

		Map<Set<Integer>, Set<String>> expected = new HashMap<>();

		expected.put(
				new HashSet<>(Arrays.asList(new Integer[] { 0, 3 })),
				new HashSet<String>(Arrays.asList(new String[] { "abba",
						"acca", "abca", "acba" })));

		expected.put(new HashSet<>(Arrays.asList(new Integer[] { 1, 3 })),
				new HashSet<String>(Arrays.asList(new String[] { "baba" })));

		expected.put(new HashSet<>(Arrays.asList(new Integer[] { 2 })),
				new HashSet<String>(Arrays.asList(new String[] { "bbab" })));

		expected.put(
				new HashSet<>(Arrays.asList(new Integer[] { 0, 1, 2 })),
				new HashSet<String>(Arrays
						.asList(new String[] { "aaab", "aaac" })));

		assertEquals(
				"Full position partition should be returnedon empty pattern '....'",
				expected, partitioner.buildPartitionsMap(words, pattern, 'a'));
	}

	@Test
	public void partialPartitionMapShouldBeReturnedOnNonEmtpyPattern() {
		ClausePartitioner partitioner = new ClausePartitioner();

		String pattern = "a..a";
		Set<String> words = new HashSet<String>();
		words.add("abba");
		words.add("abca");
		words.add("acba");
		words.add("axba");
		words.add("acca");
		words.add("axxa");

		Map<Set<Integer>, Set<String>> expected = new HashMap<>();

		expected.put(new HashSet<>(Arrays.asList(new Integer[] { 1, 2 })),
				new HashSet<String>(Arrays.asList(new String[] { "abba" })));
		expected.put(new HashSet<>(Arrays.asList(new Integer[] { 1 })),
				new HashSet<String>(Arrays.asList(new String[] { "abca" })));
		expected.put(
				new HashSet<>(Arrays.asList(new Integer[] { 2 })),
				new HashSet<String>(Arrays
						.asList(new String[] { "acba", "axba" })));
		expected.put(
				new HashSet<>(Arrays.asList(new Integer[] {})),
				new HashSet<String>(Arrays
						.asList(new String[] { "acca", "axxa" })));

		assertEquals(
				"Partial partition map should be returnedon non-empty pattern 'a..a'",
				expected, partitioner.buildPartitionsMap(words, pattern, 'b'));
	}
}
