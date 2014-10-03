package code.google;

import java.util.List;

import code.google.data.InputData;
import code.google.logic.MasterRule;
import code.google.logic.RuleBuilder;
import code.google.logic.RuleInvoker;
import code.google.skeleton.AbstractApplication;
import code.google.skeleton.AbstractParser;

public class Application extends AbstractApplication<InputData> {

	@Override
	public AbstractParser<InputData> createParser() {
		return new Parser();
	}

	@Override
	public void doStuff(List<InputData> input) {
		int i = 1;
		RuleBuilder ruleBuilder = new RuleBuilder();
		RuleInvoker ruleInvoker = new RuleInvoker();
		for (InputData inputData : input) {
			ruleInvoker.setRule(ruleBuilder.buildMasterRule(inputData));
			printResult(i, ruleInvoker.invoke(inputData.getInput()));
			i++;
		}

	}

	private void printResult(int n, String result) {
		System.out.print("Case #" + n + ": ");
		System.out.print("[");
		char[] chars = result.toCharArray();
		for (int i = 0; i < chars.length - 1; i++) {
			System.out.print(chars[i] + ", ");
		}
		if (chars.length > 0) {
			System.out.print(chars[chars.length - 1]);
		}
		System.out.print("]");
		System.out.println();

	}
}
