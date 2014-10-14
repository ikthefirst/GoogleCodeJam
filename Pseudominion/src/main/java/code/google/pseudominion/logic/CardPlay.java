package code.google.pseudominion.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import code.google.pseudominion.data.Card;
import code.google.pseudominion.data.State;

public class CardPlay {

	private static final boolean DEBUG = false;

	private Card[] cards = new Card[80];
	private List<Integer> T = new ArrayList<>(80);
	private List<Integer> C1 = new ArrayList<>(80);
	private List<Integer> C2 = new ArrayList<>(80);

	private int N;
	private boolean memoize;

	public static class MemoKey {
		public State state;
		public int score;

		public MemoKey(State state, int score) {
			super();
			this.state = state;
			this.score = score;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + score;
			result = prime * result + ((state == null) ? 0 : state.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			MemoKey other = (MemoKey) obj;
			if (score != other.score) {
				return false;
			}
			if (state == null) {
				if (other.state != null) {
					return false;
				}
			} else if (!state.equals(other.state)) {
				return false;
			}
			return true;
		}

	}

	protected Map<State, Integer> memoizedScores = new HashMap<>();
	protected Map<MemoKey, Integer> cache = new HashMap<>();

	public CardPlay(int N) {
		super();
		cards = new Card[N];
		this.N = N;
	}

	public CardPlay(int N, boolean memoize) {
		super();
		cards = new Card[N];
		this.N = N;
		this.memoize = memoize;
	}

	public Card[] getCards() {
		return cards;
	}

	public void setCards(Card[] cards) {
		this.cards = cards;
	}

	public boolean isMemoize() {
		return memoize;
	}

	public void setMemoize(boolean memoize) {
		this.memoize = memoize;
	}

	public List<Integer> getT() {
		return T;
	}

	public void setT(List<Integer> t) {
		T = t;
	}

	public List<Integer> getC1() {
		return C1;
	}

	public void setC1(List<Integer> c1) {
		C1 = c1;
	}

	public List<Integer> getC2() {
		return C2;
	}

	public void setC2(List<Integer> c2) {
		C2 = c2;
	}

	public int getN() {
		return N;
	}

	public void setN(int n) {
		N = n;
	}

	public void addCard(Card card) {
		int idx = card.getIndex();
		cards[idx] = card;
		if (card.getTurn() > 0) {
			T.add(idx);
			return;
		}
		if (card.getCard() > 1) {
			C2.add(idx);
			return;
		}
		if (card.getCard() > 0) {
			C1.add(idx);
			return;
		}
	}

	public int getMaxScore(int hand) {
		State startState = new State(hand, 1, 0, 0, 0);
		return calculateMaxScore(startState, 0, memoize);
	}

	private int calculateMaxScore(State state, int score, boolean memoize) {

		// if memoize is enabled, check if current state is already calculated
		if (memoize) {
			Integer memoized = cache.get(new MemoKey(state, score));
			if (memoized != null) {
				return memoized;
			}
		}

		if (state.turns == 0) {
			if (memoize) {
				cache.put(new MemoKey(state, score), score);
			}
			return score;
		}

		int max[] = new int[6];

		// turn card
		int cardIdx;
		if (state.t < T.size()) {
			cardIdx = T.get(state.t);
			if (cardIdx < state.hand) {
				Card card = cards[cardIdx];
				if (DEBUG) {
					System.out.println(state + " " + score);
					System.out.println("\t" + "(T)" + " -> " + card);
				}
				State s1 = new State(min(N, state.hand + card.getCard()), min(
						N, state.turns + card.getTurn() - 1), min(N,
						state.t + 1), state.c1, state.c2);
				max[0] = calculateMaxScore(s1, score + card.getScore(), memoize);
				if (memoize) {
					cache.put(new MemoKey(state, score), max[0]);
				}
				return max[0];
			}
		}
		// card with 1 extra card bonus
		if (state.c1 < C1.size()) {
			cardIdx = C1.get(state.c1);
			if (cardIdx < state.hand) {
				Card card = cards[cardIdx];
				if (DEBUG) {
					System.out.println(state + " " + score);
					System.out.println("\t" + "(C1)" + " -> " + card);
				}
				// use that card
				State s2 = new State(min(N, state.hand + 1), state.turns - 1,
						state.t, min(N, state.c1 + 1), state.c2);
				max[1] = calculateMaxScore(s2, score + card.getScore(), memoize);

				// do not use that card
				State s3 = new State(state.hand, state.turns, state.t, min(N,
						state.c1 + 1), state.c2);
				max[2] = calculateMaxScore(s3, score, memoize);
			}
		}

		// card with 2 extra card bonus
		if (state.c2 < C2.size()) {
			cardIdx = C2.get(state.c2);
			if (cardIdx < state.hand) {
				Card card = cards[cardIdx];
				if (DEBUG) {
					System.out.println(state + " " + score);
					System.out.println("\t" + "(C2)" + " -> " + card);
				}
				// use that card
				State s4 = new State(min(N, state.hand + 2), state.turns - 1,
						state.t, state.c1, min(N, state.c2 + 1));
				max[3] = calculateMaxScore(s4, score + card.getScore(), memoize);

				// do not use that card
				State s5 = new State(state.hand, state.turns, state.t,
						state.c1, min(N, state.c2 + 1));
				max[4] = calculateMaxScore(s5, score, memoize);
			}
		}

		// greedily use cards with no turn and card bonus
		if (DEBUG) {
			System.out.println(state + " " + score);
			System.out.println("\t" + "(C0)");
		}

		max[5] = score;
		List<Integer> scores = new ArrayList<>();
		for (int i = 0; i < state.hand; i++) {
			if (cards[i].getTurn() == 0 && cards[i].getCard() == 0) {
				scores.add(cards[i].getScore());
			}
		}
		Collections.sort(scores);
		int size = scores.size();

		for (int i = 0; i < size && i < state.turns; i++) {
			max[5] += scores.get(size - i - 1);
		}

		// select maximum of subresults
		for (int i = 1; i < max.length; i++) {
			if (max[i] > max[0]) {
				max[0] = max[i];
			}
		}

		// store result if memoize is enabled
		if (memoize) {
			cache.put(new MemoKey(state, score), max[0]);
		}

		return max[0];
	}

	private int min(int a, int b) {
		return a < b ? a : b;
	}

	public void print() {
		System.out.println("T cards : ");
		for (int seq : T) {
			System.out.println(cards[seq]);
		}
		System.out.println("C2 cards : ");
		for (int seq : C2) {
			System.out.println(cards[seq]);
		}
		System.out.println("C1 cards : ");
		for (int seq : C1) {
			System.out.println(cards[seq]);
		}
	}

}
