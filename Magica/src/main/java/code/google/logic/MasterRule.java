package code.google.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains other rules, executes in specified order.
 */
public class MasterRule implements Rule {

	private List<Rule> rules = new ArrayList<>();

	@Override
	public StringBuffer execute(StringBuffer elementList) {
		StringBuffer result = elementList;
		for (Rule rule : rules) {
			result = rule.execute(result);
		}
		return result;
	}

	public List<Rule> getRules() {
		return rules;
	}

	public void setRules(List<Rule> rules) {
		this.rules = rules;
	}

	public void addRule(Rule rule) {
		rules.add(rule);
	}

	public void clearRules() {
		rules.clear();
	}
}
