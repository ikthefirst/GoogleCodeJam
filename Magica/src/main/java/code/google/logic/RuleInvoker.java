package code.google.logic;

public class RuleInvoker {

	private Rule rule;

	public String invoke(String elements) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < elements.length(); i++) {
			sb.append(elements.charAt(i));
			sb = rule.execute(sb);
		}
		return sb.toString();
	}

	public Rule getRule() {
		return rule;
	}

	public void setRule(Rule rule) {
		this.rule = rule;
	}

}
