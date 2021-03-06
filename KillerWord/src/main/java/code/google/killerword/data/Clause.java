package code.google.killerword.data;

import java.util.HashSet;
import java.util.Set;

public class Clause {

	private String pattern;
	private Set<String> words;
	private int lostPoints;

	public Clause() {
		super();
		words = new HashSet<>();
	}

	public Clause(String pattern, Set<String> words, int lostPoints) {
		this();
		this.pattern = pattern;
		this.words = words;
		this.lostPoints = lostPoints;
	}

	public boolean containsCharacter(char ch) {
		for (String word : words) {
			if (word.indexOf(ch) >= 0) {
				return true;
			}
		}
		return false;
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
		return "Clause(" + pattern + ", " + words + ", " + "points="
				+ lostPoints + ")";
	}

}
