package code.google.skeleton;

import java.io.IOException;
import java.util.List;

import code.google.skeleton.AbstractParser;

/**
 * Abstract application class for executing solutions.
 */
public abstract class AbstractApplication<D> {

	public void execute(String[] args) {
		AbstractParser<D> parser = createParser();

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

		this.doStuff(parser.getInputData());
	}

	public abstract AbstractParser<D> createParser();

	public abstract void doStuff(List<D> inputData);
}
