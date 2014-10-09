package code.google.killerword;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import code.google.killerword.data.InputData;
import code.google.skeleton.AbstractParser;

public class Parser extends AbstractParser<InputData> {

	@Override
	public void parseFile(String inputFile) throws IOException {

		File file = new File(inputFile);

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = br.readLine();
			if (line == null) {
				return;
			}
			int testcaseNum = Integer.parseInt(line);
			while (testcaseNum-- > 0) {
				line = br.readLine();
				String[] tokens = line.split("\\s+");
				int numWords = Integer.parseInt(tokens[0]);
				int numTrials = Integer.parseInt(tokens[1]);
				InputData data = new InputData();
				for (int i = 0; i < numWords; i++) {
					line = br.readLine();
					data.addWord(line);
				}
				for (int i = 0; i < numTrials; i++) {
					line = br.readLine();
					data.addTrial(line);
				}
				inputData.add(data);
			}
		}
	}

	@Override
	public InputData parseLine(String line) {
		return null;
	}

}
