package code.google.killerword;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import code.google.killerword.data.InputData;
import code.google.skeleton.AbstractApplication;
import code.google.skeleton.AbstractParser;

public class ApplicationBruteForce extends AbstractApplication<InputData> {

	private final boolean DEBUG = true;

	@Override
	public AbstractParser<InputData> createParser() {
		return new Parser();
	}

	@Override
	public void doStuff(List<InputData> inputDatas) {
		int testcaseNum = 0;
		for (InputData inputData : inputDatas) {
			testcaseNum++;
			if (DEBUG) {
				System.out.println("TESTCASE #" + testcaseNum);
			}
			List<String> killerWords = new ArrayList<String>();
			for (String trial : inputData.getTrials()) {
				if (DEBUG) {
					System.out.println("trial = " + trial);
				}
				int max = 0;
				String killerWord = inputData.getDictionary().get(0);
				for (String word : inputData.getDictionary()) {
					int lostPoints = 0;
					Set<Character> wordChars = createCharacterSet(word);
					Set<String> guess = getWordsForLength(
							inputData.getDictionary(), word.length());
					Set<Character> guessChars = createCharacterSet(guess);
					for (char ch : trial.toCharArray()) {
						if (!guessChars.contains(ch)) {
							continue;
						}
						if (word.indexOf(ch) == -1) {
							lostPoints++;
						}
						wordChars.remove(ch);
						if (wordChars.isEmpty()) {
							break;
						}
						guess = collectWordsMatchingCurrentWord(guess, word, ch);
						guessChars = createCharacterSet(guess);
					}
					if (DEBUG) {
						System.out.println("    " + word + " : " + lostPoints);
					}
					if (lostPoints > max) {
						max = lostPoints;
						killerWord = word;
					}
				}
				killerWords.add(killerWord);
			}
			printResult(testcaseNum, killerWords);
		}

	}

	private Set<Character> createCharacterSet(Set<String> words) {
		Set<Character> result = new HashSet<>();
		for (String word : words) {
			result.addAll(createCharacterSet(word));
		}
		return result;
	}

	private Set<Character> createCharacterSet(String word) {
		Set<Character> result = new HashSet<>();
		for (char ch : word.toCharArray()) {
			result.add(ch);
		}
		return result;
	}

	private Set<String> collectWordsMatchingCurrentWord(Set<String> words,
			String word, char ch) {
		Set<String> result = new HashSet<String>();

		char[] chars = word.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ch) {
				sb.append(ch);
			} else {
				sb.append(".");
			}
		}
		Pattern pattern = Pattern.compile(sb.toString());

		for (String s : words) {
			Matcher matcher = pattern.matcher(s);
			if (matcher.matches()) {
				result.add(s);
			}
		}

		return result;
	}

	private Set<String> getWordsForLength(List<String> words, int length) {
		Set<String> result = new HashSet<>();
		for (String word : words) {
			if (word.length() == length) {
				result.add(word);
			}
		}
		return result;
	}

	private void printResult(int n, List<String> result) {
		System.out.print("Case #" + n + ": ");
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i));
			if (i < result.size() - 1) {
				System.out.print(" ");
			}
		}
		System.out.println();
	}
}
