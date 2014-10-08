package code.google.killerword.logic;

import java.util.HashSet;
import java.util.Set;

import code.google.killerword.data.Clause;

public class ClausePartitioner {

	/**
	 * 
	 * 
	 * @param clause
	 * @param ch
	 * @return
	 */
	public Set<Clause> partition(Clause clause, char ch) {
		Set<Clause> nextClauseSet = new HashSet<>();

		// TODO: add logic

		return nextClauseSet;
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
		// TODO: add logic

		return null;
	}

}
