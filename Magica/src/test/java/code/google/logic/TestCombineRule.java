package code.google.logic;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestCombineRule {

	@Test
	public void ruleShouldCombineLastTwoElementsComingInOrder() {
		CombineRule rule = new CombineRule();
		rule.addRuleElement('A');
		rule.addRuleElement('B');
		rule.setCombinedElement('C');

		String input = "XXXXAB";
		String output = "XXXXC";

		String result = rule.execute(new StringBuffer(input)).toString();

		assertEquals(
				"Rule should combine last two elements if they are coming in order.",
				output, result);
	}

	@Test
	public void ruleShouldCombineLastTwoElementsInComingRevereseOrder() {
		CombineRule rule = new CombineRule();
		rule.addRuleElement('A');
		rule.addRuleElement('B');
		rule.setCombinedElement('C');

		String input = "XXXXBA";
		String output = "XXXXC";

		String result = rule.execute(new StringBuffer(input)).toString();

		assertEquals(
				"Rule should combine last two elements if they are coming in reverse order.",
				output, result);
	}

	@Test
	public void ruleShouldOnlyCombineIfLastTwoElementsAreSpecified() {
		CombineRule rule = new CombineRule();

		String input = "AAAAXY";
		String output = "AAAAXY";
		Set<Character> ruleElements = new HashSet<>();

		StringBuffer elementList = new StringBuffer(input);

		ruleElements.clear();
		ruleElements.add('A');
		ruleElements.add('X');
		elementList = rule.execute(elementList);

		ruleElements.clear();
		ruleElements.add('A');
		ruleElements.add('Y');
		elementList = rule.execute(elementList);

		String result = elementList.toString();

		assertEquals(
				"Rule should only combine if both last two elements are specified in the rule.",
				output, result);
	}

	@Test
	public void ruleShouldNotCombineIfNoLastElementsIsSpecified() {
		CombineRule rule = new CombineRule();
		rule.addRuleElement('A');
		rule.addRuleElement('B');
		rule.setCombinedElement('C');

		String input = "XXXXZY";
		String output = "XXXXZY";

		String result = rule.execute(new StringBuffer(input)).toString();

		assertEquals(
				"Rule should not combine if neither of the last two elements are specified.",
				output, result);
	}

	@Test
	public void ruleShouldNotCombineOnOneLongElementList() {
		CombineRule rule = new CombineRule();
		rule.addRuleElement('A');
		rule.addRuleElement('B');
		rule.setCombinedElement('C');

		String input = "A";
		String output = "A";
		String result = rule.execute(new StringBuffer(input)).toString();

		assertEquals(
				"Rule should combine last two chars if they are coming in reverse order.",
				output, result);
	}

	@Test
	public void ruleShouldLeaveEmptyElementList() {
		CombineRule rule = new CombineRule();
		rule.addRuleElement('A');
		rule.addRuleElement('B');
		rule.setCombinedElement('C');

		String input = "";
		String output = "";
		String result = rule.execute(new StringBuffer(input)).toString();

		assertEquals("Rule should leave empty element list unmodified.",
				output, result);
	}

	@Test
	public void ruleShouldCombineOnlyIfMatchingElementsDiffer() {
		CombineRule rule = new CombineRule();
		rule.addRuleElement('A');
		rule.addRuleElement('B');
		rule.setCombinedElement('C');

		String input = "XYXYAA";
		String output = "XYXYAA";
		String result = rule.execute(new StringBuffer(input)).toString();

		assertEquals("Rule should leave empty element list unmodified.",
				output, result);
	}

	@Test
	public void ruleShouldCombineIfOneElementIsSpecifiedAndTwoElementMatches() {
		CombineRule rule = new CombineRule();
		rule.addRuleElement('A');
		rule.addRuleElement('A');
		rule.setCombinedElement('C');

		String input = "XYXYAA";
		String output = "XYXYC";
		String result = rule.execute(new StringBuffer(input)).toString();

		assertEquals("Rule should leave empty element list unmodified.",
				output, result);
	}

}
