package code.google.logic;

import java.util.Set;

import org.junit.Test;

import code.google.data.InputData;
import static org.junit.Assert.*;

public class TestRuleBuilder {

	@Test
	public void combineRuleShouldContainElements() {
		RuleBuilder builder = new RuleBuilder();
		CombineRule rule = builder.buildCombineRule("ABC");
		Set<Character> elements = rule.getRuleElements();
		assertTrue("", elements.contains('A') && elements.contains('B'));
	}

	@Test
	public void combineRuleShouldMatchCombinedElement() {
		RuleBuilder builder = new RuleBuilder();
		CombineRule rule = builder.buildCombineRule("ABC");
		assertEquals("", 'C', rule.getCombinedElement());
	}

	@Test
	public void opposeRuleShouldContainElements() {
		RuleBuilder builder = new RuleBuilder();
		OpposeRule rule = builder.buildOpposeRule("MN");
		Set<Character> elements = rule.getRuleElements();
		assertTrue("", elements.contains('M') && elements.contains('N'));
	}

	@Test
	public void masterRuleShouldContainCombineRuleOnFirstPlace() {
		RuleBuilder builder = new RuleBuilder();
		InputData inputData = new InputData();
		inputData.addCombineRule("ABC");
		inputData.addOpposeRule("XY");
		MasterRule rule = builder.buildMasterRule(inputData);
		assertTrue("", rule.getRules().get(0) instanceof CombineRule);
	}

	@Test
	public void masterRuleShouldContainOpposeRuleOnSecondPlace() {
		RuleBuilder builder = new RuleBuilder();
		InputData inputData = new InputData();
		inputData.addCombineRule("ABC");
		inputData.addOpposeRule("XY");
		MasterRule rule = builder.buildMasterRule(inputData);
		assertTrue("", rule.getRules().get(1) instanceof OpposeRule);
	}

}
