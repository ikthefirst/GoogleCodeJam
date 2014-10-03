package code.google.logic;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import static org.junit.Assert.*;
import code.google.logic.*;

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

}
