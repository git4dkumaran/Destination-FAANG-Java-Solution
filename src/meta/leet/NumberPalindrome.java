package meta.leet;

public class NumberPalindrome {

	public static void main(String[] args) {

		NumberPalindrome np = new NumberPalindrome();
//		System.out.println("-4444  IS NumberPalindrome " + np.isPalindrome(-4444));
//
//		System.out.println("4444 IS NumberPalindrome " + np.isPalindrome(4444));
//
//		System.out.println("101 IS NumberPalindrome " + np.isPalindrome(101));

		//System.out.println("-4444  IS NumberPalindrome " + np.checkPalindrome(-4444));

		//System.out.println("4444 IS NumberPalindrome " + np.checkPalindrome(4444));

		System.out.println("101 IS NumberPalindrome " + np.checkPalindrome(101101101));

	}

	public boolean isPalindrome(int x) {

		boolean isPalin = true;
		String value = new String(x + "");

		int left1 = x / 10;
		int right1 = x % 10;

		for (int left = 0, right = value.length() - 1; left < right; left++, right--) {
			if (value.charAt(left) != value.charAt(right)) {
				isPalin = false;
				break;
			}
		}
		return isPalin;

	}

	// Function to check Palindrome
	static boolean checkPalindrome(int n) {
		int reverse = 0;
		int temp = n;
		//System.out.println(" temp " + temp);
		while (temp != 0) {
			reverse = (reverse * 10) + (temp % 10);

			System.out.println(" reverse " + reverse);
			
			temp = temp / 10;

			System.out.println(" temp " + temp);
		}
		
		

		System.out.println(" Final reverse " + reverse);
		return (reverse == n); // if it is true then it will return 1;
		// else if false it will return 0;
	}
}
