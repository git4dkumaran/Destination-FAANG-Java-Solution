package guidewire;

import java.util.ArrayList;
import java.util.List;

//you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution {
	private static final String REGEX = "[^a-zA-Z?.!]";
	
	public int solution(String inputStr) {
		// Implement your solution here
		// make sure the string is not empty or null
		int maxWordCount = 0;
		
		System.out.println(" Input String --> " + inputStr );
		if ( !isValidString(inputStr)) {
			//throw new Exception("String is not in the expected format");
			System.out.println("The given string is not in the expected format");
			return maxWordCount;
		}
		
		String[] sentenses = inputStr.split("[.?!]");
		
		System.out.println(" Number of Sentenses -- > " + sentenses.length );

		// if there are any sentense found then 
		if(sentenses != null && sentenses.length > 0) { 
			for(String sentense : sentenses ) {
				System.out.println(" sentense --> " + sentense);
				String[] words = sentense.split(" "); 

				//a Word must contain at least one letter so trimming all the continuous spaces
				int wordCount = 0;
				for(String word : words) {
					if (!word.trim().isEmpty() ) {
						wordCount++;
					}
				}
				
				System.out.println(" Number of Words -- > " + wordCount );				
				if (maxWordCount < wordCount) {
					maxWordCount = wordCount;
				}
			}
		}
		return maxWordCount;
	}

	  
	private boolean isValidString(String inputStr) {
		if (inputStr == null ) {
			return false;
		}
		
		if (inputStr.isEmpty() || inputStr.trim().isEmpty()) {
			System.out.println(" There are no character in this string  [ " + inputStr  + " ] ");
			return false;
		}
		
		if (inputStr.length() >100) {
			System.out.println(" Given String in greater than 100 Characters  [ "  + inputStr + " ]");
			return false;
		}  
		return true;
	}
	
	
	public static void main(String[] args) {
		Solution s = new Solution();
		
		List<String> testData = new ArrayList<String>();
		testData.add("We test coders. Give us a try?");
		testData.add("Forget     CVs..Save time . x x");
		testData.add("you can write to stdout for debugging purposes, e.g. System.out.println(this is a debug message");
		testData.add("");
		testData.add("     ");
		testData.add(null);
		testData.add("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
		testData.add("t t t t t t t t t t t" );
		testData.add(". ? !!!!??   . ."); 
		
		testData.add("you can write to stdout for debugging purposes, e.g. System.out.println(this is a debug message System.out.println(this is a debug message System.out.println(this is a debug message System.out.println(this is a debug message ");
		
		for(String data : testData ) {
			System.out.println(  "\n Maximum number of words  in  ( " + data  + " ) is "+ s.solution(data) + " \n\n  " );	
		}
	}
}
