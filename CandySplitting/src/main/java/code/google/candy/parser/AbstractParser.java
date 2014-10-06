package code.google.candy.parser;

import java.io.IOException;

/**
 * Interface for parsing input.
 */
public abstract class AbstractParser {

	public abstract void parseFile(String inputFile) throws IOException;

	public abstract void parseLine(String line);

	public abstract void setInputData(Object data);

	public abstract Object getInputData();

}
