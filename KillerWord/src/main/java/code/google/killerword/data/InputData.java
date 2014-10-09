package code.google.killerword.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputData {

	private List<String> dictionary = new ArrayList<String>();
	private List<String> trials = new ArrayList<String>();

	public InputData() {
		super();
	}

	public InputData(List<String> dictionary, List<String> trials) {
		super();
		this.dictionary = dictionary;
		this.trials = trials;
	}

	public List<String> getDictionary() {
		return dictionary;
	}

	public void setDictionary(List<String> dictionary) {
		this.dictionary = dictionary;
	}

	public List<String> getTrials() {
		return trials;
	}

	public void setTrials(List<String> trials) {
		this.trials = trials;
	}

	public void addWord(String word) {
		dictionary.add(word);
	}

	public void addTrial(String trial) {
		trials.add(trial);
	}

}
