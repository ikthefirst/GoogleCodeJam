package code.google.logic;

import java.util.Set;

/**
 * Combines the LAST TWO elements in the element list, if they match any given
 * rule elements.
 */
public class CombineRule implements Rule {

	private Set<Character> ruleElements;
	private char combinedElement;

	@Override
	public StringBuffer execute(StringBuffer elementList) {

		return elementList;

	}

	private StringBuffer combine(StringBuffer elementList) {
		return elementList;
	}

	public char getCombinedElement() {
		return combinedElement;
	}

	public void setCombinedElement(char combinedElement) {
		this.combinedElement = combinedElement;
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
