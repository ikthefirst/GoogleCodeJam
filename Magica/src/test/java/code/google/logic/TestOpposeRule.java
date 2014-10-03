package code.google.logic;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestOpposeRule {

	@Test
	public void ruleShouldNotEraseIfFirstElementNotMatch() {
		OpposeRule rule = new OpposeRule();
		rule.addRuleElement('A');
		rule.addRuleElement('B');

		String input = "XXXXXA";
		String output = "XXXXXA";

		String result = rule.execute(new StringBuffer(input)).toString();

		assertEquals("Rule should not erase if first element not match.",
				output, result);
	}

	@Test
	public void ruleShouldNotEraseIfLastElementNotMatch() {
		OpposeRule rule = new OpposeRule();
		rule.addRuleElement('A');
		rule.addRuleElement('B');

		String input = "AXXXXC";
		String output = "AXXXXC";

		String result = rule.execute(new StringBuffer(input)).toString();

		assertEquals("Rule should not erase if last element not match.",
				output, result);
	}

	@Test
	public void ruleShouldEraseIfFirstAndLastElementMatchAndDifferent() {
		OpposeRule rule = new OpposeRule();
		rule.addRuleElement('A');
		rule.addRuleElement('B');

		String input = "AXXXXB";
		String output = "";

		String result = rule.execute(new StringBuffer(input)).toString();

		assertEquals(
				"Rule should erase if first and last elements are different, and match.",
				output, result);
	}

	@Test
	public void ruleShouldEraseIfFirstAndLastElementsAreTheSameAndSpecifiedAreAlsoTheSame() {
		OpposeRule rule = new OpposeRule();
		rule.addRuleElement('A');
		rule.addRuleElement('A');

		String input = "AXXXXA";
		String output = "";

		String result = rule.execute(new StringBuffer(input)).toString();

		assertEquals(
				"Rule should erase if the same elements are specified on both end, and the first and last element matches to that element.",
				output, result);
	}

}
