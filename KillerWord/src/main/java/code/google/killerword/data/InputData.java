package code.google.killerword.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputData {

	private Set<String> dictionary = new HashSet<String>();
	private List<String> trySequences = new ArrayList<String>();

	public Set<String> getDictionary() {
		return dictionary;
	}

	public void setDictionary(Set<String> dictionary) {
		this.dictionary = dictionary;
	}

	public List<String> getTrySequences() {
		return trySequences;
	}

	public void setTrySequences(List<String> trySequences) {
		this.trySequences = trySequences;
	}

	public void addWord(String word) {
		dictionary.add(word);
	}

	public void addTrySequence(String trySequence) {
		trySequences.add(trySequence);
	}

}
