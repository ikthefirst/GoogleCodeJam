package code.google.killerword.logic;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import code.google.killerword.data.Clause;

public class ClauseEvaluator {

	private static final boolean DEBUG = false;

	private ClauseCalculator calculator = new ClauseCalculator();
	private ClausePartitioner partitioner = new ClausePartitioner();

	public Set<String> determineKillerWords(String trial,
			Map<Integer, Clause> startClauses) {
		if (DEBUG) {
			System.out.println("*** [" + trial + "] ***");
		}
		Set<Clause> maxLostPointClauses = new HashSet<Clause>();
		int maxLostPoints = 0;

		// create unprocessed queue
		LinkedList<Clause> unprocessed = new LinkedList<Clause>();
		for (Clause clause : startClauses.values()) {
			unprocessed.addLast(clause);
		}

		char[] trialCharacters = trial.toCharArray();

		LinkedList<Clause> partitioned = new LinkedList<Clause>();
		for (char ch : trialCharacters) {
			if (DEBUG) {
				System.out.println(ch + ", " + unprocessed);
			}
			while (!unprocessed.isEmpty()) {
				Clause clause = unprocessed.pop();
				if (clause.containsCharacter(ch)) {
					partitioned.addAll(partitioner.partition(clause, ch));
				} else {
					partitioned.add(clause);
				}

				// if (DEBUG) {
				// System.out.println(" P: " + partitioned);
				// }

				Set<Clause> finished = calculator.extractFinished(partitioned);
				if (DEBUG) {
					System.out.println(" -> " + finished);
				}

				maxLostPoints = calculator.extractMaxLostPointClauses(finished,
						maxLostPointClauses, maxLostPoints);
			}
			unprocessed = partitioned;
			partitioned = new LinkedList<Clause>();
		}

		Set<String> words = new HashSet<String>();
		for (Clause maxClause : maxLostPointClauses) {
			words.addAll(maxClause.getWords());
		}
		if (DEBUG) {
			System.out.println("MAX: " + maxLostPointClauses);
			System.out.println("MAX: " + words);
		}

		return words;
	}

	public String getFirstWord(List<String> words, Set<String> wordSet) {
		if (wordSet.size() > 0) {
			for (String word : words) {
				if (wordSet.contains(word)) {
					return word;
				}
			}
		}
		return wordSet.iterator().next();

	}

}