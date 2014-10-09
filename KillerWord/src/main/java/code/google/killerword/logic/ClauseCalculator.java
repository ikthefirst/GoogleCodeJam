package code.google.killerword.logic;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import code.google.killerword.data.Clause;
import code.google.killerword.data.InputData;

public class ClauseCalculator {

	public boolean isFinished(Clause clause) {
		return clause.getWords().size() == 1;
	}

	public Set<Clause> extractFinished(Collection<Clause> clauseSet) {
		Set<Clause> finishedSet = new HashSet<Clause>();
		Iterator<Clause> it = clauseSet.iterator();
		while (it.hasNext()) {
			Clause clause = it.next();
			if (isFinished(clause)) {
				it.remove();
				finishedSet.add(clause);
			}
		}
		return finishedSet;
	}

	public int extractMaxLostPointClauses(Collection<Clause> clauseSet,
			Collection<Clause> maxSet, int currentMax) {
		int max = currentMax;
		for (Clause clause : clauseSet) {
			int points = clause.getLostPoints();
			if (points == max) {
				maxSet.add(clause);
				continue;
			}
			if (points > max) {
				max = points;
				maxSet.clear();
				maxSet.add(clause);
			}
		}
		return max;
	}

	public Map<Integer, Clause> initializeClauses(InputData inputData) {
		Map<Integer, Clause> clauses = new HashMap<>();
		Map<Integer, Set<String>> wordsByLength = buildWordsByLengthMap(inputData);
		for (Entry<Integer, Set<String>> entry : wordsByLength.entrySet()) {
			int length = entry.getKey();
			Set<String> words = entry.getValue();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < length; i++) {
				sb.append(".");
			}

			clauses.put(length, new Clause(sb.toString(), words, 0));
		}

		return clauses;
	}

	public Set<Character> buildCharacterSetForWords(Set<String> words) {
		Set<Character> chars = new HashSet<Character>();
		for (String word : words) {
			for (char ch : word.toCharArray()) {
				chars.add(ch);
			}
			if (chars.size() >= 'z' - 'a') {
				break;
			}
		}

		return chars;
	}

	public Map<Integer, Set<String>> buildWordsByLengthMap(InputData inputData) {
		Map<Integer, Set<String>> wordsByLength = new HashMap<Integer, Set<String>>();

		for (String word : inputData.getDictionary()) {
			int length = word.length();

			Set<String> words = wordsByLength.get(length);
			if (words == null) {
				words = new HashSet<String>();
				wordsByLength.put(length, words);
			}
			words.add(word);
		}

		return wordsByLength;
	}

}
