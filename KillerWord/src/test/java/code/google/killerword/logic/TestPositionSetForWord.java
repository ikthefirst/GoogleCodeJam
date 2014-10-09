package code.google.killerword.logic;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestPositionSetForWord {

	private String word;
	private String pattern;
	private char ch;
	private Set<Integer> expectedPositions;
	private ClausePartitioner partitioner;

	@Before
	public void initialize() {
		partitioner = new ClausePartitioner();
	}

	@Parameterized.Parameters
	public static Collection wordPositions() {
		return Arrays
				.asList(new Object[][] {
						{
								"abba",
								"....",
								'a',
								new HashSet<Integer>(Arrays
										.asList(new Integer[] { 0, 3 })) },
						{
								"baba",
								"....",
								'a',
								new HashSet<Integer>(Arrays
										.asList(new Integer[] { 1, 3 })) },
						{
								"bbab",
								"....",
								'a',
								new HashSet<Integer>(Arrays
										.asList(new Integer[] { 2 })) },
						{
								"aaab",
								"....",
								'a',
								new HashSet<Integer>(Arrays
										.asList(new Integer[] { 0, 1, 2 })) },
						{
								"abba",
								"a..a",
								'b',
								new HashSet<Integer>(Arrays
										.asList(new Integer[] { 1, 2 })) },
						{
								"aaba",
								"a..a",
								'b',
								new HashSet<Integer>(Arrays
										.asList(new Integer[] { 2 })) },
						{ "abba", "....", 'x', new HashSet<Integer>() }, });
	}

	public TestPositionSetForWord(String word, String pattern, char ch,
			Set<Integer> expected) {
		this.word = word;
		this.pattern = pattern;
		this.ch = ch;
		this.expectedPositions = expected;
	}

	@Test
	public void calculateWordPositions() {
		assertEquals("ClausePartitioner.calculatePositionSet(" + word + ", "
				+ pattern + ", " + ch + ")", expectedPositions,
				partitioner.calculatePositionSet(word, pattern, ch));
	}
}
