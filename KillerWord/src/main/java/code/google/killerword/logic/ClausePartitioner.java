package code.google.killerword.logic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import code.google.killerword.data.Clause;

public class ClausePartitioner {

	/**
	 * Partition a clause based on a character.
	 * 
	 * @param clause
	 * @param ch
	 * @return
	 */
	public Set<Clause> partition(Clause clause, char ch) {
		Set<Clause> nextClauseSet = new HashSet<>();

		String pattern = clause.getPattern();

		// build up partitions map
		Map<Set<Integer>, Set<String>> partitionsMap = buildPartitionsMap(
				clause.getWords(), pattern, ch);

		// generate new clauses based on partitions map
		for (Entry<Set<Integer>, Set<String>> entry : partitionsMap.entrySet()) {
			String newPattern = buildPattern(pattern, entry.getKey(), ch);
			Clause newClause = createNewClause(newPattern, entry.getKey(),
					entry.getValue(), clause.getLostPoints());
			nextClauseSet.add(newClause);
		}

		return nextClauseSet;
	}

	public Clause createNewClause(String pattern, Set<Integer> positions,
			Set<String> words, int lostPoints) {
		Clause newClause = new Clause();
		newClause.setPattern(pattern);
		newClause.setWords(words);

		// if the words do not contain the character, increment lost points
		if (positions.isEmpty()) {
			newClause.setLostPoints(lostPoints + 1);
		} else {
			newClause.setLostPoints(lostPoints);
		}
		return newClause;
	}

	public String buildPattern(String pattern, Set<Integer> positions, char ch) {
		char[] patternChars = pattern.toCharArray();
		for (int pos : positions) {
			if (patternChars[pos] == '.') {
				patternChars[pos] = ch;
			}
		}
		return new String(patternChars);
	}

	/**
	 * Build up partitions map for a set of words, based on a pattern and a
	 * given character.
	 * 
	 * @param clause
	 * @param ch
	 * @param pattern
	 */
	public Map<Set<Integer>, Set<String>> buildPartitionsMap(Set<String> words,
			String pattern, char ch) {
		Map<Set<Integer>, Set<String>> partitionsMap = new HashMap<>();

		for (String word : words) {
			Set<Integer> positionSet = calculatePositionSet(word, pattern, ch);
			Set<String> wordsSet = partitionsMap.get(positionSet);
			if (wordsSet == null) {
				wordsSet = new HashSet<String>();
				partitionsMap.put(positionSet, wordsSet);
			}
			wordsSet.add(word);
		}

		return partitionsMap;
	}

	/**
	 * Calculate the position set for a given word on a given character.<br>
	 * Eg: <br>
	 * "aaba", 'a' -> (0, 1, 3)<br>
	 * "baba", 'a' -> (1, 3)
	 * 
	 * @param clause
	 * @param ch
	 * @return
	 */
	public Set<Integer> calculatePositionSet(String word, String pattern,
			char ch) {
		Set<Integer> positionSet = new HashSet<Integer>();
		for (int i = 0; i < word.length(); i++) {
			if (pattern.charAt(i) != '.') {
				continue;
			}
			if (word.charAt(i) == ch) {
				positionSet.add(i);
			}
		}
		return positionSet;
	}
}
