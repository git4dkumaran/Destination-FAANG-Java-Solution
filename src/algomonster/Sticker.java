package algomonster;

import java.util.ArrayDeque;
import java.util.Deque;

//https://algo.monster/liteproblems/691
// https://leetcode.com/problems/stickers-to-spell-word/description/

// https://leetcode.com/problems/stickers-to-spell-word/
public class Sticker {

	public int minStickers(String[] stickers, String target) {
		// Initialize a queue to store the states of characters from the target string
		Deque<Integer> queue = new ArrayDeque<>();
		queue.offer(0); // Start with an empty state (no characters covered)
		int answer = 0; // Number of stickers used
		int n = target.length(); // Length of the target string
		boolean[] visited = new boolean[1 << n]; // Visited states to avoid repetition
		visited[0] = true; // Mark the empty state as visited

		// While there are states in the queue, continue processing
		while (!queue.isEmpty()) {
			// Process all states at the current level
			for (int t = queue.size(); t > 0; --t) {
				// Get and remove the current state from the queue
				int currentState = queue.poll();
				// If all characters are covered, return the count
				if (currentState == (1 << n) - 1) {
					return answer;
				}
				// Try to cover more characters using each sticker
				for (String sticker : stickers) {
					int nextState = currentState; // Start with the current state
					int[] charCount = new int[26]; // Frequency of each character in sticker
					for (char c : sticker.toCharArray()) {
						++charCount[c - 'a'];
					}
					// Try to match sticker characters with uncovered characters in the target
					for (int i = 0; i < n; ++i) {
						int targetCharIndex = target.charAt(i) - 'a';
						// If the character at position i is not covered and
						// the sticker has the character, cover it and decrement the sticker's count
						if ((nextState & (1 << i)) == 0 && charCount[targetCharIndex] > 0) {
							nextState |= 1 << i;
							--charCount[targetCharIndex];
						}
					}
					// If the next state has not been visited, mark it as visited and add to queue
					if (!visited[nextState]) {
						visited[nextState] = true;
						queue.offer(nextState);
					}
				}
			}
			// Increment the count after processing all states at the current level
			++answer;
		}

		// Return -1 if it's not possible to cover all the characters in the target
		// string
		return -1;
	}
	
	
	public static void main(String[] args) {
		Sticker s = new Sticker();
		int numOfStickers = s.minStickers(new String[] {"facebook"}, "boo");
		
		System.out.println("  Number  Of Stickers " + numOfStickers);
 
		numOfStickers = s.minStickers(new String[] {"facebook"}, "booboobooooo");
		
		System.out.println("  Number  Of Stickers " + numOfStickers);
		
		
		numOfStickers = s.minStickers(new String[] {"with","example","science"}, "thehat");
		System.out.println("  Number  Of Stickers " + numOfStickers);
		
		
		numOfStickers = s.minStickers(new String[] {"notice","possible"}, "basicbasic");
		System.out.println("  Number  Of Stickers " + numOfStickers);
	
		 
		
	}
}
