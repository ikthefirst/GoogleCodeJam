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

		char lastChar = elementList.charAt(elementList.length() - 1);
		if (!ruleElements.contains(lastChar)) {
			return elementList;
		}

		for (int i = 0; i < elementList.length() - 1; i++) {
			char ch = elementList.charAt(i);
			if (ruleElements.contains(ch)) {
				if (ch != lastChar || ruleElements.size() == 1) {
					return new StringBuffer();
				}
			}
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
