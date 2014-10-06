package code.google.goro.skeleton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Interface for parsing input.
 */
public abstract class AbstractParser<D> {

	private List<D> inputData = new ArrayList<D>();

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
				D data = parseLine(line);
				inputData.add(data);
			}
		}
	}

	/**
	 * Parse line, collect input to input data.
	 */
	public abstract D parseLine(String line);

	public List<D> getInputData() {
		return inputData;
	}

}
