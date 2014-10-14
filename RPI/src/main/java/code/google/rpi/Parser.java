package code.google.rpi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import code.google.rpi.data.InputData;
import code.google.skeleton.AbstractParser;

public class Parser extends AbstractParser<InputData> {

	public void parseFile(String inputFile) throws IOException {

		File file = new File(inputFile);

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = br.readLine();
			if (line == null) {
				return;
			}
			int testcaseNum = Integer.parseInt(line);
			int curr = 0;
			while (curr++ < testcaseNum) {
				line = br.readLine();
				int N = Integer.parseInt(line);
				InputData input = new InputData(N);
				byte[][] games = input.getGames();
				for (int i = 0; i < N; i++) {
					line = br.readLine();
					char[] chars = line.toCharArray();
					for (int j = 0; j < chars.length; j++) {
						byte game = -1;
						switch (chars[j]) {
						case '0': {
							game = 0;
							break;
						}
						case '1': {
							game = 1;
							break;
						}
						default:
							break;
						}
						games[i][j] = game;
					}
				}
				input.setGames(games);
				inputData.add(input);
			}
		}
	}

	@Override
	public InputData parseLine(String line) {
		return null;
	}

}
