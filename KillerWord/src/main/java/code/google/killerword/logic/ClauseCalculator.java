package code.google.killerword.logic;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import code.google.killerword.data.Clause;

public class ClauseCalculator {

	public boolean isFinished(Clause clause) {
		return clause.getWords().size() == 1;
	}

	public Set<Clause> extractFinished(Set<Clause> clauseSet) {
		Set<Clause> finishedSet = new HashSet<Clause>();
		for (Clause clause : clauseSet) {
			if (isFinished(clause)) {
				clauseSet.remove(clause);
				finishedSet.add(clause);
			}
		}
		return finishedSet;
	}

}
