package code.google.goro.logic.permutation;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String args[]) {
		Permutations permutation = new Permutations();
		permutation.printPermutations(permutation.generateNumbers(5));
	}

	public void printPermutations(List<Integer> numbers) {
		printPermutation(new ArrayList<Integer>(), numbers);
	}

	private void printPermutation(List<Integer> head, List<Integer> tail) {
		if (tail.size() == 0) {
			System.out.print(head + " : " + calculateNumbersInPosition(head));
			System.out.println();
		} else {
			for (int i = 0; i < tail.size(); i++) {
				List<Integer> newHead = new ArrayList<Integer>(head);
				List<Integer> newTail = new ArrayList<Integer>(tail);
				newHead.add(newTail.remove(i));
				printPermutation(newHead, newTail);
			}
		}
	}

	private int calculateNumbersInPosition(List<Integer> numbers) {
		int n = 0;
		for (int i = 0; i < numbers.size(); i++) {
			if (numbers.get(i) == i + 1) {
				n++;
			}
		}
		return n;
	}

	private List<Integer> generateNumbers(int n) {
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			numbers.add(i);
		}
		return numbers;
	}
}
