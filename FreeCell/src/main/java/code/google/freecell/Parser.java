package code.google.freecell;

import code.google.freecell.data.InputData;
import code.google.freecell.skeleton.AbstractParser;

public class Parser extends AbstractParser<InputData> {

	@Override
	public InputData parseLine(String line) {
		InputData inputData = new InputData();

		String[] tokens = line.split("\\s+");
		inputData.setMaxGamesToday(Integer.parseInt(tokens[0]));
		inputData.setWinPercentageToday(Integer.parseInt(tokens[1]));
		inputData.setWinPercentageTotal(Integer.parseInt(tokens[2]));

		return inputData;
	}

}
