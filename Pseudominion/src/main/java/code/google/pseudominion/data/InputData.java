package code.google.pseudominion.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class InputData {

	private int hand = 0;
	private List<Card> cards = new ArrayList<>();

	public InputData() {
		super();
	}

	public InputData(int hand) {
		super();
		this.hand = hand;
	}

	public int getHand() {
		return hand;
	}

	public void setHand(int hand) {
		this.hand = hand;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public void addCard(Card card) {
		cards.add(card);
	}

}
