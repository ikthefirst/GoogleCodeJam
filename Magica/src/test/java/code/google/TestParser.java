package code.google;

import org.junit.Test;

import code.google.data.InputData;
import static org.junit.Assert.*;

public class TestParser {

	@Test
	public void parserShouldAddProperNumberOfCombineRules() {
		Parser parser = new Parser();
		InputData inputData = parser.parseLine("2 XYZ XYZ 0 3 ABC");

		assertEquals("", 2, inputData.getCombineRules().size());
	}

	@Test
	public void parserShouldAddProperNumberOfOpposeRules() {
		Parser parser = new Parser();
		InputData inputData = parser.parseLine("0 3 AB CD EF 3 ABC");

		assertEquals("", 3, inputData.getOpposeRules().size());
	}

	@Test
	public void parserShouldAddProperCombineRule() {
		Parser parser = new Parser();
		InputData inputData = parser.parseLine("1 XYZ 0 3 ABC");
		String combineRule = inputData.getCombineRules().get(0);

		assertEquals("", "XYZ", combineRule);
	}

	@Test
	public void parserShouldAddProperOpposeRule() {
		Parser parser = new Parser();
		InputData inputData = parser.parseLine("0 1 DE 3 ABC");
		String opposeRule = inputData.getOpposeRules().get(0);

		assertEquals("", "DE", opposeRule);
	}

	@Test
	public void parserShouldAddInput() {
		Parser parser = new Parser();
		InputData inputData = parser.parseLine("2 XYZ XYZ  3 AB CD EF 3 ABC");

		assertEquals("", "ABC", inputData.getInput());
	}

}
