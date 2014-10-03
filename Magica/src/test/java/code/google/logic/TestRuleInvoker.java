package code.google.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestRuleInvoker {

	@Test
	public void ruleInvokerShouldDoItsTaskProperly1() {
		MasterRule masterRule = new MasterRule();

		CombineRule combineRule;
		combineRule = new CombineRule();
		combineRule.addRuleElement('X');
		combineRule.addRuleElement('Y');
		combineRule.setCombinedElement('T');
		masterRule.addRule(combineRule);

		combineRule = new CombineRule();
		combineRule.addRuleElement('X');
		combineRule.addRuleElement('T');
		combineRule.setCombinedElement('Z');
		masterRule.addRule(combineRule);

		OpposeRule opposeRule;
		opposeRule = new OpposeRule();
		opposeRule.addRuleElement('A');
		opposeRule.addRuleElement('Z');
		masterRule.addRule(opposeRule);

		RuleInvoker invoker = new RuleInvoker();
		invoker.setRule(masterRule);

		String input = "AXYYXXAXXYCXYXXXYXYX";
		String output = "CZZZ";

		String result = invoker.invoke(input);

		assertEquals("Rule invoker test.", output, result);
	}

	@Test
	public void ruleInvokerShouldDoItsTaskProperly2() {
		MasterRule masterRule = new MasterRule();

		CombineRule combineRule;
		combineRule = new CombineRule();
		combineRule.addRuleElement('X');
		combineRule.setCombinedElement('T');
		masterRule.addRule(combineRule);

		combineRule = new CombineRule();
		combineRule.addRuleElement('X');
		combineRule.addRuleElement('T');
		combineRule.setCombinedElement('Z');
		masterRule.addRule(combineRule);

		OpposeRule opposeRule;
		opposeRule = new OpposeRule();
		opposeRule.addRuleElement('Z');
		opposeRule.addRuleElement('T');
		masterRule.addRule(opposeRule);

		RuleInvoker invoker = new RuleInvoker();
		invoker.setRule(masterRule);

		String input = "XXXXXA";
		String output = "A";

		String result = invoker.invoke(input);

		assertEquals("Rule invoker test.", output, result);
	}
}
