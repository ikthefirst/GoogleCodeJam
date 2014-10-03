package code.google;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {

	public Parser() {
		super();
	}

	public void parseFile(String input, List<List<ProgramEntry>> testcases)
			throws IOException {
		File file = new File(input);

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = br.readLine();
			if (line == null) {
				return;
			}
			int testcaseNum = Integer.parseInt(line);
			while (testcaseNum > 0) {
				line = br.readLine();
				testcases.add(parseLine(line));
				testcaseNum--;
			}
		}
	}

	protected List<ProgramEntry> parseLine(String line) {
		List<ProgramEntry> program = new ArrayList<>();

		ProgramEntry currentEntry = null;
		ProgramEntry previousEntry = null;
		String[] tokens = line.split("\\s+");
		int programsNum = Integer.parseInt(tokens[0]);
		for (int i = 0; i < programsNum; i++) {
			String robotName = tokens[2 * i + 1];
			Integer position = Integer.parseInt(tokens[2 * i + 2]);
			currentEntry = new ProgramEntry(robotName, position, previousEntry);
			program.add(currentEntry);
			previousEntry = currentEntry;
		}

		return program;
	}
}
