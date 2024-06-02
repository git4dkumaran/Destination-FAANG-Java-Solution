package meta.leet;

public class LongestCommonPrefix {

	/**
	 * 
	 * https://leetcode.com/problems/longest-common-prefix/description/?source=submission-ac.
	 * 
	 * Write a function to find the longest common prefix string amongst an array of
	 * strings.
	 * 
	 * If there is no common prefix, return an empty string "".
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: strs = ["flower","flow","flight"] Output: "fl" Example 2:
	 * 
	 * Input: strs = ["dog","racecar","car"] Output: "" Explanation: There is no
	 * common prefix among the input strings.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LongestCommonPrefix lcp = new LongestCommonPrefix();

		System.out.println( " longestCommonPrefix "  + lcp.longestCommonPrefix(new String[]{"flower","flow","flight"}) );


		System.out.println( " longestCommonPrefix "  + lcp.longestCommonPrefix(new String[]{"dog","racecar","car"}) );

	}

	
//	https://algo.monster/liteproblems/14F
	// Method to find the longest common prefix from an array of strings.
	public String longestCommonPrefix(String[] strs) {
		int numberOfStrings = strs.length; // Total number of strings in the array.

		// Loop through each character of the first string.
		for (int index = 0; index < strs[0].length(); ++index) {
			// Compare the character with the same position in the remaining strings.
			for (int stringIndex = 1; stringIndex < numberOfStrings; ++stringIndex) {
				// Check two conditions here:
				// 1. If the current string is shorter than the current character index, or
				// 2. If the current character does not match the character in the first string.
				// In either case, that means we've found the end of the common prefix.
				if (strs[stringIndex].length() <= index || strs[stringIndex].charAt(index) != strs[0].charAt(index)) {
					// Therefore, we return the substring from the start to the current index from
					// the first string.
					return strs[0].substring(0, index);
				}
			}
		}

		// If we manage to check all characters of the first string without finding a
		// mismatch,
		// it means that the entire first string is a common prefix.
		return strs[0];
	}

}
