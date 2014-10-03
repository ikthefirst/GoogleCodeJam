package code.google.logic;

import java.util.Set;

/**
 * Erase the element list, if the first and last elements match the specified
 * rule elements. Same elements can only be matched, if only one rule element is
 * specified.
 */
public class OpposeRule implements Rule {

	private Set<Character> ruleElements;
	private char secondElement;

	@Override
	public StringBuffer execute(StringBuffer elementList) {
		// TODO Auto-generated method stub
		return null;
	}

	public char getSecondElement() {
		return secondElement;
	}

	public void setSecondElement(char secondElement) {
		this.secondElement = secondElement;
	}

	public Set<Character> getRuleElements() {
		return ruleElements;
	}

	public void setRuleElements(Set<Character> ruleElements) {
		this.ruleElements = ruleElements;
	}

	public void addRuleElement(char element) {
		ruleElements.add(element);
	}

}
