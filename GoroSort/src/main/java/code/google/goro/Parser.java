package code.google.goro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import code.google.goro.skeleton.AbstractParser;

public class Parser extends AbstractParser<List<Integer>> {

	@Override
	public List<Integer> parseLine(String line) {
		List<Integer> result = new ArrayList<>();

		String[] tokens = line.split("\\s+");
		for (String token : tokens) {
			result.add(Integer.parseInt(token));
		}

		return result;
	}

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
				line = br.readLine();
				List<Integer> data = parseLine(line);
				inputData.add(data);
			}
		}
	}
}
