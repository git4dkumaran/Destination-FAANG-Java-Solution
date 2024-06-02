package algomonster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


// https://algo.monster/problems/find_all_anagrams
class Anagrams {
	public static List<Integer> findAllAnagrams(String original, String check) {
		int originalLen = original.length();
		int checkLen = check.length();
		ArrayList<Integer> res = new ArrayList<>();
		if (originalLen < checkLen)
			return res;

		// stores the frequency of each character in the check string
		int[] checkCounter = new int[26];
		// stores the frequency of each character in the current window
		int[] window = new int[26];
		// first window
		for (int i = 0; i < checkLen; i++) {
			System.out.println("\ncheck.charAt(" + i + ") "  + check.charAt(i));
			
			checkCounter[check.charAt(i) - 'a']++;
			
			print(checkCounter);
			
			System.out.println("\nwindow.original(" + i + ") "  + original.charAt(i));
			window[original.charAt(i) - 'a']++;
			print(window);
			System.out.println("");
		}
		if (Arrays.equals(window, checkCounter))
			res.add(0);

		for (int i = checkLen; i < originalLen; i++) {
			window[original.charAt(i - checkLen) - 'a']--;
			window[original.charAt(i) - 'a']++;
			if (Arrays.equals(window, checkCounter))
				res.add(i - checkLen + 1);
		}
		return res;
	}

	private static void print(int[] checkCounter) {
		for(int i = 0; i < checkCounter.length; i++) {
		//	System.out.print(", " + checkCounter[i]);
		}
		
	}

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
		String original = null; //scanner.nextLine();
		String check = null; //scanner.nextLine();
//		scanner.close();
		
		original = "cbaebabacd";
		check = "abc";
		
		List<Integer> res = findAllAnagrams(original, check);

		System.out.println(  " *********************** RESULT .. " );
		
		System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));

		
		original = "abab";
		check = "ab";
		res = findAllAnagrams(original, check);
		System.out.println(  " *********************** RESULT .. " );
		System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));

		
		original = "anagram";
		check = "nagaram";
		res = findAllAnagrams(original, check);
		System.out.println(  " *********************** RESULT .. " );
		System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));
 
		
	}
}
