package code.google.logic;

import java.util.HashSet;
import java.util.Set;

/**
 * Erase the element list, if the first and last elements match the specified
 * rule elements. Same elements can only be matched, if only one rule element is
 * specified.
 */
public class OpposeRule implements Rule {

	private Set<Character> ruleElements = new HashSet<>();
	private char secondElement;

	@Override
	public StringBuffer execute(StringBuffer elementList) {
		if (elementList.length() < 2) {
			return elementList;
		}

		char firstChar = elementList.charAt(0);
		char lastChar = elementList.charAt(elementList.length() - 1);

		if (firstChar == lastChar && ruleElements.size() > 1) {
			return elementList;
		}

		if (ruleElements.contains(firstChar) && ruleElements.contains(lastChar)) {
			return new StringBuffer();
		}

		return elementList;
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
