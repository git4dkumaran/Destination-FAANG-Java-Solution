package meta;

import java.util.Stack;

/* The knows API is defined in the parent class Relation.
boolean knows(int a, int b); */

// https://www.geeksforgeeks.org/the-celebrity-problem/

public class Celebrity {

	// Person with 2 is celebrity
	static int MATRIX[][] = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } };

	// Returns true if a knows
	// b, false otherwise
	static boolean knows(int a, int b) {
		boolean res = (MATRIX[a][b] == 1) ? true : false;
		return res;
	}

	/**
	 * The Celebrity Problem using Elimination Technique: Some observations are
	 * based on elimination technique (Refer to Polya’s How to Solve It book).
	 * 
	 * If A knows B, then A can’t be a celebrity. Discard A, and B may be celebrity.
	 * If A doesn’t know B, then B can’t be a celebrity. Discard B, and A may be
	 * celebrity. Repeat above two steps till there is only one person. Ensure the
	 * remained person is a celebrity. (What is the need of this step?) Follow the
	 * steps below to solve the problem:
	 * 
	 * Create a stack and push all the ids in the stack. Run a loop while there are
	 * more than 1 element in the stack. Pop the top two elements from the stack
	 * (represent them as A and B) If A knows B, then A can’t be a celebrity and
	 * push B in the stack. Else if A doesn’t know B, then B can’t be a celebrity
	 * push A in the stack. Assign the remaining element in the stack as the
	 * celebrity. Run a loop from 0 to n-1 and find the count of persons who knows
	 * the celebrity and the number of people whom the celebrity knows. If the count
	 * of persons who knows the celebrity is n-1 and the count of people whom the
	 * celebrity knows is 0 then return the id of the celebrity else return -1.
	 * Below is the implementation of the above approach:
	 * 
	 * @param n
	 * @return
	 */

	// The Celebrity Problem using Elimination Technique:

	// Returns -1 if celebrity
	// is not present. If present,
	// returns id (value from 0 to n-1).
	static int findCelebrity(int n) {
		Stack<Integer> st = new Stack<>();
		int celebrity;

		// Step 1 :Push everybody
		// onto stack
		for (int i = 0; i < n; i++) {
			st.push(i);
		}

		while (st.size() > 1) {
			// Step 2 :Pop off top
			// two persons from the
			// stack, discard one
			// person based on return
			// status of knows(A, B).
			int a = st.pop();
			int b = st.pop();

			// Step 3 : Push the
			// remained person onto stack.
			if (knows(a, b)) {
				st.push(b);
			} else {
				st.push(a);
			}
		}

		// If there are only two people
		// and there is no
		// potential candidate
		if (st.empty())
			return -1;

		celebrity = st.pop();

		// Step 5 : Check if the last
		// person is celebrity or not
		for (int i = 0; i < n; i++) {
			// If any person doesn't
			// know 'c' or 'a' doesn't
			// know any person, return -1
			if (i != celebrity && (knows(celebrity, i) || !knows(i, celebrity)))
				return -1;
		}
		return celebrity;
	}

	// Driver Code
	public static void main(String[] args) {
		int n = 4;
		int result = findCelebrity(n);
		if (result == -1) {
			System.out.println("No Celebrity");
		} else
			System.out.println("Celebrity ID " + result);

		
		
		// The Celebrity Problem using Elimination Technique (Efficient):

		int M[][] = { { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 1, 0 } };

		int a = celebrity(MATRIX, 4);
		if (a == -1) {
			System.out.println("No Celebrity");
		} else {
			System.out.println("Celebrity ID " + a);
		}

	}

	// The Celebrity Problem using Elimination Technique (Efficient):

	/**
	 * The idea is to follow below to steps based on the above approach:
	 * 
	 * If A knows B, then A can’t be a celebrity. Discard A, and B may be celebrity.
	 * If A doesn’t know B, then B can’t be a celebrity. Discard B, and A may be
	 * celebrity. We will not use any extra space as will use spaces M[i][i] for
	 * storing whether i th person is a celebrity or not as these are by default 0,
	 * so if we find i th person is not a celebrity then we will mark M[i][i] as 1
	 * 
	 */

	// Function to find if there is a celebrity in the party
	// or not.
	// https://www.geeksforgeeks.org/the-celebrity-problem/
	static int celebrity(int M[][], int n) {
		// r=row number
		int r = 0;
		for (int i = 1; i < n; i++) {
			// checking if r th person knows i th person
			if (M[r][i] == 1) {
				M[r][r] = 1;
				r = i;
			} else {
				M[i][i] = 1;
			}
		}
		for (int i = 0; i < n; i++) {
			// checking if i th person can be a celebrity or
			// not
			if (M[i][i] == 0) {
				int flag = 0;
				// iterating in the i th column to check
				// whether everyone knows i th person or not
				for (int j = 0; j < n; j++) {
					// checking if M[j][i] is not a diagonal
					// element and if j th person knows i th
					// person
					if (j != i && M[j][i] == 0) {
						flag = 1;
						break;
					}
				}
				if (flag == 0)
					return i;
			}
		}
		return -1;
	}

}