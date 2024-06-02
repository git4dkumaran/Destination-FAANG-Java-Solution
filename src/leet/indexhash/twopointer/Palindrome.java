package leet.indexhash.twopointer;

public class Palindrome {

	public boolean isPalindrome(String s) {
		boolean isPalindrome = true;
		if (s == null || s.trim().isEmpty()) {
			return isPalindrome;
		}

		s = s.replaceAll("[^a-zA-Z0-9]", "");

		char[] chars = s.trim().toLowerCase().toCharArray();
		// amanaplanacanalpanama [AmanaplanacanalPanama]
		int len = s.length();
		for (int i = 0, j = len - 1; i < len / 2; i++, j--) {
			if (chars[i] != chars[j]) {
				isPalindrome = false;
				break;
			}
		}
		System.out.println(new String(chars) + " isPalindrome " + isPalindrome);
		return isPalindrome;

	}

	/** An alternate solution using Java 8 Streams */
	public boolean isPalindromeUsingStreams(String s) {
		StringBuilder builder = new StringBuilder();

		s.chars().filter(c -> Character.isLetterOrDigit(c))
				 .mapToObj(c -> Character.toLowerCase((char) c))
				 .forEach(builder::append);

		return builder.toString().equals(builder.reverse().toString());
	}

	public static void main(String[] args) {
		String[] strs = { "A man, a plan, a canal: Panama", "race a car", "", "ate", "nat", "bat" };
		Palindrome ga = new Palindrome();

		for (String s : strs) {
			ga.isPalindrome(s);
		}
	}

}
