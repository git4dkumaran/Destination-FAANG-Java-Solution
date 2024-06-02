package leet.indexhash;

import java.util.Arrays;

public class Anagram {

	public boolean isAnagram(String s, String t) {
		boolean isAnagram = false;
		if (s == null && t == null) {
			return isAnagram;
		}

		if (s.equalsIgnoreCase(t)) {
			isAnagram = true;
			return isAnagram;
		}
		char[] sChars = s.toCharArray();
		char[] tChars = t.toCharArray();
		Arrays.sort(sChars);
		Arrays.sort(tChars);

		if ( Arrays.equals(sChars, tChars) ) {
			return true;
		} 

		return isAnagram;
	}

	public static void main(String[] args) {
		 Anagram a = new Anagram();
		 System.out.println( "anagram   is nagaram " +  a.isAnagram("anagram", "nagaram") );;
		 System.out.println( "rat   is car " +  a.isAnagram("rat", "car") );;

		 
		 
	}

}
