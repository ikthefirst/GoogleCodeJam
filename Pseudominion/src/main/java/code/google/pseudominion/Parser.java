package code.google.pseudominion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import code.google.pseudominion.data.Card;
import code.google.pseudominion.data.InputData;
import code.google.skeleton.AbstractParser;

public class Parser extends AbstractParser<InputData> {

	private static final boolean DEBUG = false;

	@Override
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
				if (DEBUG) {
					System.out.println("Testcase #" + curr + " : ");
				}
				InputData input = new InputData();
				line = br.readLine();
				if (DEBUG) {
					System.out.println(line);
				}
				int numHands = Integer.parseInt(line);
				input.setHand(numHands);
				int seq = 0;
				for (int i = 0; i < numHands; i++) {
					line = br.readLine();
					if (DEBUG) {
						System.out.println(line);
					}
					String[] tokens = line.split("\\s+");
					int c = Integer.parseInt(tokens[0]);
					int s = Integer.parseInt(tokens[1]);
					int t = Integer.parseInt(tokens[2]);
					input.addCard(new Card(seq, c, s, t));
					seq++;
				}
				line = br.readLine();
				if (DEBUG) {
					System.out.println(line);
				}
				int numDeck = Integer.parseInt(line);
				for (int i = 0; i < numDeck; i++) {
					line = br.readLine();
					if (DEBUG) {
						System.out.println(line);
					}
					String[] tokens = line.split("\\s+");
					int c = Integer.parseInt(tokens[0]);
					int s = Integer.parseInt(tokens[1]);
					int t = Integer.parseInt(tokens[2]);
					input.addCard(new Card(seq, c, s, t));
					seq++;
				}
				this.inputData.add(input);
			}
		}

		// print();
	}

	@Override
	public InputData parseLine(String line) {
		return null;
	}

	private void print() {
		System.out.println(inputData.size());
		int i = 0;
		for (InputData input : inputData) {
			i++;
			System.out.println("Testcase #" + i + " : ");
			for (Card card : input.getCards()) {
				System.out.println(card);
			}
		}
	}
}
