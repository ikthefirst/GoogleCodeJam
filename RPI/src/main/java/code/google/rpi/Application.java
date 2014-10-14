package code.google.rpi;

import java.util.List;

import code.google.rpi.data.InputData;
import code.google.rpi.logic.RatingsPercentageCalculator;
import code.google.skeleton.AbstractApplication;
import code.google.skeleton.AbstractParser;

public class Application extends AbstractApplication<InputData> {

	@Override
	public AbstractParser<InputData> createParser() {
		return new Parser();
	}

	@Override
	public void doStuff(List<InputData> inputData) {
		RatingsPercentageCalculator calculator = new RatingsPercentageCalculator();

		int n = 0;
		for (InputData input : inputData) {
			n++;
			byte[][] games = input.getGames();
			int N = input.getN();

			float[] wps = calculator.calculateWP(games, N);

			byte[] numGames = calculator.getNumGames();
			float[] owps = calculator.calculateOWP(games, numGames, N);

			float[] oowps = calculator.calculateOOWP(games, owps, N);

			float[] rpis = calculator.calculateRPI(wps, owps, oowps, N);

			System.out.println("Case #" + n + ":");
			for (float rpi : rpis) {
				System.out.println(rpi);
			}
		}
	}
}
