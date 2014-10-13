package code.google.pseudominion.data;

public class Card {

	private int card;
	private int score;
	private int turn;

	public Card() {
		super();
	}

	public Card(int card, int score, int turn) {
		super();
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

}
