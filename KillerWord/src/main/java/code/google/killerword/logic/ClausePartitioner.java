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
		Set<Character> characterSet = clause.getContainedCharacters();
		characterSet.remove(ch);
		for (Entry<Set<Integer>, Set<String>> entry : partitionsMap.entrySet()) {
			Clause newClause = new Clause();

			// build pattern for new clause
			char[] patternChars = pattern.toCharArray();
			for (int pos : entry.getKey()) {
				patternChars[pos] = ch;
			}

			// create new clause
			newClause.setContainedCharacters(characterSet);
			newClause.setPattern(new String(patternChars));
			newClause.setWords(entry.getValue());

			// if the words do not contain the character, increment lost points
			if (entry.getKey().isEmpty()) {
				newClause.setLostPoints(clause.getLostPoints() + 1);
			} else {
				newClause.setLostPoints(clause.getLostPoints());
			}
			nextClauseSet.add(newClause);
		}

		return nextClauseSet;
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
	 * Partition a clause based on if character at a given position. If
	 * partition happens, the new clause is returned, otherwise null is
	 * returned. If partition happens, the words are moved from the old clause
	 * to the newly created one, so in this case the method modifies the clause
	 * passed in the argument.
	 * 
	 * @param clauseSet
	 * @param ch
	 * @param pos
	 * @return
	 */
	public Clause partition(Clause clause, char ch, int pos) {
		String pattern = clause.getPattern();
		if (pos < 0 || pos >= pattern.length()) {
			return null;
		}
		if (pattern.charAt(pos) != '.') {
			return null;
		}

		clause.removeCharacter(ch);

		Set<String> words = clause.getWords();
		Set<String> matchingWords = new HashSet<>();

		for (String word : words) {
			if (word.charAt(pos) == ch) {
				clause.removeWord(word);
				matchingWords.add(word);
			}
		}

		if (matchingWords.size() == 0) {
			clause.setLostPoints(clause.getLostPoints() + 1);
			return null;
		}

		char[] patternArray = pattern.toCharArray();
		patternArray[pos] = ch;

		Clause newClause = new Clause(clause.getContainedCharacters(),
				new String(patternArray), matchingWords, clause.getLostPoints());

		return newClause;
	}

	/**
	 * Calculate position sets for a given clause, considering actual pattern.<br>
	 * Eg:<br>
	 * Clause("....", {"abba", "baba", "bbab", "aaab"}), 'a' <br>
	 * -> { {0,3}, {1,3}, {2}, {0,1,2} }<br>
	 * Clause("a..a", {"abba", "abca", "acca"}), 'b' <br>
	 * -> { {1,2}, {2}, {} }
	 * 
	 * 
	 * @param clause
	 * @param ch
	 * @return
	 */
	public Set<Set<Integer>> calculatePositionSets(Clause clause, char ch) {
		Set<Set<Integer>> positionSets = new HashSet<>();
		String pattern = clause.getPattern();

		for (String word : clause.getWords()) {
			positionSets.add(calculatePositionSet(word, pattern, ch));
		}

		return positionSets;
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
