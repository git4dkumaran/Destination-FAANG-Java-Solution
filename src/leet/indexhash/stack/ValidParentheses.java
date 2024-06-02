package leet.indexhash.stack;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
	// Hash table that takes care of the mappings.
	private HashMap<Character, Character> mappings;

	public ValidParentheses() {
		this.mappings = new HashMap<Character, Character>();
		this.mappings.put(')', '(');
		this.mappings.put('}', '{');
		this.mappings.put(']', '[');
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (mappings.containsKey(c)) {
				char top = stack.isEmpty() ? '$' : stack.pop();
				if (top != this.mappings.get(c)) {
					return false;
				}
			} else {
				stack.push(c);
			}
		}

		return stack.isEmpty();
	}

	public static void main(String[] args) {
		ValidParentheses par = new ValidParentheses();
		System.out.println(" () is Valid " + par.isValid("()"));
		System.out.println(" ()[]{} is Valid " + par.isValid("()[]{}"));
		System.out.println(" (] is Valid " + par.isValid("(]"));
		System.out.println(" {[]} is Valid " + par.isValid("{[]}"));
		System.out.println(" ( is Valid " + par.isValid("("));
		System.out.println(" ] is Valid " + par.isValid("]"));

	}

}
