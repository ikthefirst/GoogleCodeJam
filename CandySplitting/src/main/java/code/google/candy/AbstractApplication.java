package code.google.candy;

import java.io.IOException;

import code.google.candy.parser.AbstractParser;

/**
 * Abstract application class for executing solutions.
 */
public abstract class AbstractApplication {

	public void execute(String[] args) {
		AbstractParser parser = createParser();
		parser.setInputData(getInputData());

		if (args.length > 0) {
			try {
				parser.parseFile(args[0]);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				parser.parseFile("in/example.in");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		this.doStuff();
	}

	public abstract AbstractParser createParser();

	public abstract Object getInputData();

	public abstract void doStuff();
}
