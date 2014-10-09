package code.google.killerword;

import java.util.List;

import code.google.killerword.data.InputData;
import code.google.skeleton.AbstractApplication;
import code.google.skeleton.AbstractParser;

public class Application extends AbstractApplication<InputData> {

	@Override
	public AbstractParser<InputData> createParser() {
		return new Parser();
	}

	@Override
	public void doStuff(List<InputData> inputData) {
		// TODO Auto-generated method stub

	}

}
