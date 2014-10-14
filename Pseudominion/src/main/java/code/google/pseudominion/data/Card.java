package code.google.pseudominion.data;

public class Card {

	private int index;

	private int card;
	private int score;
	private int turn;

	public Card(int seq) {
		super();
		this.index = seq;
	}

	public Card(int seq, int card, int score, int turn) {
		this(seq);
		this.card = card;
		this.score = score;
		this.turn = turn;
	}

	public int getCard() {
		return card;
	}

	public void setCard(int card) {
		this.card = card;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int seq) {
		this.index = seq;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + index;
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
		Card other = (Card) obj;
		if (index != other.index) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Card [seq=" + index + ", card=" + card + ", score=" + score
				+ ", turn=" + turn + "]";
	}

}
