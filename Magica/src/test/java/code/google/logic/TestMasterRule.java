package code.google.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestMasterRule {

	@Test
	public void ruleShouldNotEraseIfElementsCanBeCombinedAtTheEnd() {
		CombineRule combineRule = new CombineRule();
		combineRule.addRuleElement('X');
		combineRule.addRuleElement('B');
		combineRule.setCombinedElement('C');

		OpposeRule opposeRule = new OpposeRule();
		opposeRule.addRuleElement('A');
		opposeRule.addRuleElement('B');

		MasterRule rule = new MasterRule();
		rule.addRule(combineRule);
		rule.addRule(opposeRule);

		String input = "AXXXXB";
		String output = "AXXXC";

		String result = rule.execute(new StringBuffer(input)).toString();

		assertEquals(
				"Rule should not erase element list, if the last two elements can be combined.",
				output, result);
	}

	@Test
	public void ruleShouldEraseIfElementsCanNotBeCombinedAtTheEnd() {
		CombineRule combineRule = new CombineRule();
		combineRule.addRuleElement('Y');
		combineRule.addRuleElement('B');
		combineRule.setCombinedElement('C');

		OpposeRule opposeRule = new OpposeRule();
		opposeRule.addRuleElement('A');
		opposeRule.addRuleElement('B');

		MasterRule rule = new MasterRule();
		rule.addRule(combineRule);
		rule.addRule(opposeRule);

		String input = "AXXXXB";
		String output = "";

		String result = rule.execute(new StringBuffer(input)).toString();

		assertEquals(
				"Rule should not erase element list, if the last two elements can be combined.",
				output, result);
	}

	@Test
	public void twoCombineRulesShouldCombine() {
		CombineRule combineRule0 = new CombineRule();
		combineRule0.addRuleElement('X');
		combineRule0.addRuleElement('Y');
		combineRule0.setCombinedElement('T');

		CombineRule combineRule1 = new CombineRule();
		combineRule1.addRuleElement('X');
		combineRule1.addRuleElement('T');
		combineRule1.setCombinedElement('Z');

		MasterRule rule = new MasterRule();
		rule.addRule(combineRule0);
		rule.addRule(combineRule1);

		String input = "XXY";
		String output = "Z";

		String result = rule.execute(new StringBuffer(input)).toString();

		assertEquals("Rule should combine the two combine rules.", output,
				result);
	}

	@Test
	public void twoCombineRulesShouldAlterOpposeRule() {
		CombineRule combineRule0 = new CombineRule();
		combineRule0.addRuleElement('X');
		combineRule0.addRuleElement('Y');
		combineRule0.setCombinedElement('T');

		CombineRule combineRule1 = new CombineRule();
		combineRule1.addRuleElement('X');
		combineRule1.addRuleElement('T');
		combineRule1.setCombinedElement('Z');

		OpposeRule opposeRule = new OpposeRule();
		opposeRule.addRuleElement('A');
		opposeRule.addRuleElement('Z');

		MasterRule rule = new MasterRule();
		rule.addRule(combineRule0);
		rule.addRule(combineRule1);
		rule.addRule(opposeRule);

		String input = "AXXXXXXXXY";
		String output = "";

		String result = rule.execute(new StringBuffer(input)).toString();

		assertEquals(
				"Rule two combine rules should alter the outcome of oppose rule.",
				output, result);
	}

}
