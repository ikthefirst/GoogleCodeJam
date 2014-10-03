package code.google;

import code.google.data.InputData;
import code.google.skeleton.AbstractParser;

public class Parser extends AbstractParser<InputData> {

	@Override
	public InputData parseLine(String line) {
		InputData inputData = new InputData();
		String[] tokens = line.split("\\s+");
		int i = 0;
		int combineNum = Integer.parseInt(tokens[i]);
		i++;
		for (; combineNum > 0; combineNum--, i++) {
			inputData.addCombineRule(tokens[i]);
		}
		int opposeNum = Integer.parseInt(tokens[i]);
		i++;
		for (; opposeNum > 0; opposeNum--, i++) {
			inputData.addOpposeRule(tokens[i]);
		}
		// int inputLength = Integer.parseInt(tokens[i]);
		i++;
		inputData.setInput(tokens[i]);

		return inputData;
	}
}
