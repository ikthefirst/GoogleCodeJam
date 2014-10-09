package code.google.killerword.logic;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import code.google.killerword.data.Clause;

public class ClauseEvaluator {

	private ClauseCalculator calculator = new ClauseCalculator();
	private ClausePartitioner partitioner = new ClausePartitioner();

	public Set<String> determineKillerWords(String trial,
			Map<Integer, Clause> startClauses) {
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
			while (!unprocessed.isEmpty()) {
				partitioned
						.addAll(partitioner.partition(unprocessed.pop(), ch));
				Set<Clause> finished = calculator.extractFinished(partitioned);

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

		return words;
	}

}