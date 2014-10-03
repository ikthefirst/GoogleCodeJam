package code.google.logic;

import code.google.data.InputData;

public class RuleBuilder {

	public MasterRule buildMasterRule(InputData inputData) {
		MasterRule masterRule = new MasterRule();

		for (String combineRule : inputData.getCombineRules()) {
			masterRule.addRule(buildCombineRule(combineRule));
		}

		for (String opposeRule : inputData.getOpposeRules()) {
			masterRule.addRule(buildOpposeRule(opposeRule));
		}

		return masterRule;
	}

	public CombineRule buildCombineRule(String ruleText) {
		CombineRule combineRule = new CombineRule();
		combineRule.addRuleElement(ruleText.charAt(0));
		combineRule.addRuleElement(ruleText.charAt(1));
		combineRule.setCombinedElement(ruleText.charAt(2));
		return combineRule;
	}

	public OpposeRule buildOpposeRule(String ruleText) {
		OpposeRule opposeRule = new OpposeRule();
		opposeRule.addRuleElement(ruleText.charAt(0));
		opposeRule.addRuleElement(ruleText.charAt(1));
		return opposeRule;
	}

}
