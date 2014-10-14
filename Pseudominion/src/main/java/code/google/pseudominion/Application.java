package code.google.pseudominion;

import java.util.List;

import code.google.pseudominion.data.Card;
import code.google.pseudominion.data.InputData;
import code.google.pseudominion.logic.CardPlay;
import code.google.skeleton.AbstractApplication;
import code.google.skeleton.AbstractParser;

public class Application extends AbstractApplication<InputData> {

	@Override
	public AbstractParser<InputData> createParser() {
		return new Parser();
	}

	@Override
	public void doStuff(List<InputData> inputData) {
		int n = 1;
		// System.out.println(inputData.size()); // OK
		for (InputData input : inputData) {
			CardPlay play = new CardPlay(input.getCards().size());
			play.setMemoize(true);
			for (Card card : input.getCards()) {
				// System.out.println("Adding: " + card);
				play.addCard(card);
			}
			// play.print(); // OK

			// System.out.println("hand : " + input.getHand());
			int max = play.getMaxScore(input.getHand());
			System.out.println("Case #" + n + ": " + max);
			n++;
		}

	}

}
