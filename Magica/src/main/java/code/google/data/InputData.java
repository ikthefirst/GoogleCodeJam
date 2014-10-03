package code.google.data;

import java.util.ArrayList;
import java.util.List;

public class InputData {

	private String input;
	private List<String> combineRules = new ArrayList<String>();
	private List<String> opposeRules = new ArrayList<String>();

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public List<String> getCombineRules() {
		return combineRules;
	}

	public void setCombineRules(List<String> combineRules) {
		this.combineRules = combineRules;
	}

	public List<String> getOpposeRules() {
		return opposeRules;
	}

	public void setOpposeRules(List<String> opposeRules) {
		this.opposeRules = opposeRules;
	}

	public void addCombineRule(String rule) {
		combineRules.add(rule);
	}

	public void addOpposeRule(String rule) {
		opposeRules.add(rule);
	}

}
