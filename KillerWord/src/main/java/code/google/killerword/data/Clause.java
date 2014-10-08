package code.google.killerword.data;

import java.util.HashSet;
import java.util.Set;

public class Clause {

	private Set<Character> containedCharacters;
	private String pattern;
	private Set<String> words;
	private int lostPoints;

	public Clause() {
		super();
	}

	public Clause(String pattern, Set<String> words, int lostPoints) {
		super();
		this.pattern = pattern;
		this.words = words;
		this.lostPoints = lostPoints;
	}

	public Clause(Set<Character> containedCharacters, String pattern,
			Set<String> words, int lostPoints) {
		super();
		this.containedCharacters = containedCharacters;
		this.pattern = pattern;
		this.words = words;
		this.lostPoints = lostPoints;
	}

	public Set<Character> getContainedCharacters() {
		return new HashSet<Character>(containedCharacters);
	}

	public void setContainedCharacters(Set<Character> containedCharacters) {
		this.containedCharacters = containedCharacters;
	}

	public void removeCharacter(char ch) {
		containedCharacters.remove(ch);
	}

	public void addCharacter(char ch) {
		containedCharacters.add(ch);
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public Set<String> getWords() {
		return new HashSet<String>(words);
	}

	public void setWords(Set<String> words) {
		this.words = words;
	}

	public void removeWord(String word) {
		words.remove(word);
	}

	public void addWord(String word) {
		words.add(word);
	}

	public int getLostPoints() {
		return lostPoints;
	}

	public void setLostPoints(int lostPoints) {
		this.lostPoints = lostPoints;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((containedCharacters == null) ? 0 : containedCharacters
						.hashCode());
		result = prime * result + lostPoints;
		result = prime * result + ((pattern == null) ? 0 : pattern.hashCode());
		result = prime * result + ((words == null) ? 0 : words.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Clause other = (Clause) obj;
		if (containedCharacters == null) {
			if (other.containedCharacters != null) {
				return false;
			}
		} else if (!containedCharacters.equals(other.containedCharacters)) {
			return false;
		}
		if (lostPoints != other.lostPoints) {
			return false;
		}
		if (pattern == null) {
			if (other.pattern != null) {
				return false;
			}
		} else if (!pattern.equals(other.pattern)) {
			return false;
		}
		if (words == null) {
			if (other.words != null) {
				return false;
			}
		} else if (!words.equals(other.words)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Clause(" + pattern + ", " + words + ", " + lostPoints + ")";
	}

}
