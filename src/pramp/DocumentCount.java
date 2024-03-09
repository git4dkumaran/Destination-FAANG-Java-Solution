package pramp;

import java.io.*;
import java.util.*;

class DocumentCount {

	private static class Word {
		int count = 0;
		int firstIndex = 0;
		String word;

		@Override
		public String toString() {
			return "word: " + this.word + " count: " + this.count + " index: " + this.firstIndex;
		}

	}

	static String[][] wordCountEngine(String document) {
		// your code goes here
		Map<String, Word> count = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < document.length(); i++) {
			if (document.charAt(i) == ' ') {
				String key = sb.toString();

				if (count.get(key) == null) {
					count.put(key, new Word());
					Word word = count.get(key);
					word.firstIndex = i;
					word.word = key;
				}
				Word word = count.get(key);
				word.count++;

				sb = new StringBuilder();
			} else if (document.charAt(i) >= 'a' && document.charAt(i) <= 'z'
					|| document.charAt(i) >= 'A' && document.charAt(i) <= 'Z') {
				char c = document.charAt(i);
				if (c >= 'A' && c <= 'Z') {
					c = (char) (c - 'A' + 'a');
				}
				sb.append(c);
			}
		}

		String key = sb.toString();

		if (count.get(key) == null) {
			count.put(key, new Word());
			Word word = count.get(key);
			word.firstIndex = document.length();
			word.word = key;
		}
		Word word = count.get(key);
		word.count++;
		count.remove("");
		count.remove(" ");
		List<Word> list = new ArrayList<>();
		for (Word entry : count.values()) {
			list.add(entry);
		}

		Collections.sort(list, (a, b) -> {
			if (a.count == b.count) {
				return a.firstIndex - b.firstIndex;
			}

			return b.count - a.count;
		});

		String[][] ans = new String[list.size()][2];

		for (int i = 0; i < ans.length; i++) {
			ans[i][0] = list.get(i).word;
			ans[i][1] = list.get(i).count + "";
		}

		return ans;
	}

	public static void main(String[] args) {
		String[][] ans = wordCountEngine("Practice makes perfect. you'll only get Perfect by practice. just practice!");

		for (String[] strs : ans) {
			System.out.println(Arrays.toString(strs));
		}

	}

}