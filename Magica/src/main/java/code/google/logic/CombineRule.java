package code.google.logic;

import java.util.HashSet;
import java.util.Set;

/**
 * Combines the LAST TWO elements in the element list, if they match any given
 * rule elements.
 */
public class CombineRule implements Rule {

	private Set<Character> ruleElements = new HashSet<>();
	private char combinedElement;

	@Override
	public StringBuffer execute(StringBuffer elementList) {
		if (elementList.length() < 2) {
			return elementList;
		}

		char beforeLastChar = elementList.charAt(elementList.length() - 2);
		char lastChar = elementList.charAt(elementList.length() - 1);

		if (beforeLastChar == lastChar && ruleElements.size() > 1) {
			return elementList;
		}

		if (ruleElements.contains(beforeLastChar)
				&& ruleElements.contains(lastChar)) {
			return combine(elementList);
		}

		return elementList;
	}

	private StringBuffer combine(StringBuffer elementList) {
		elementList.deleteCharAt(elementList.length() - 1);
		elementList.setCharAt(elementList.length() - 1, combinedElement);
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
