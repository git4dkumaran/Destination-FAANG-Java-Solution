package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddNumbers {

	/**
	 * 
	 * https://www.linkedin.com/pulse/how-java-streams-make-your-code-more-efficient-nikhil-gargatte/
	 * 
	 * In this example, the parallelStream() method creates a parallel stream from
	 * the list of numbers. The filter() and reduce() methods then filter out all
	 * the odd numbers and add up all the even numbers. The parallel processing can
	 * lead to a significant speedup in performance, especially for large
	 * collections of data.
	 * 
	 * @param num
	 * @return
	 */
	public int sumIt(int num) {

		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			numbers.add(i);
		}

		int sum = numbers.parallelStream().filter(n -> n % 2 == 0).reduce(0, Integer::sum);
		System.out.println(sum);
		return sum;

	}

	/**
	 * Here's an example: Let's say you have a list of strings and you want to find
	 * the length of the longest string. With a for loop, you might write code like
	 * this:
	 * 
	 * With Java streams, you can write the same code using the mapToInt(), max(),
	 * and orElse() methods:
	 * 
	 * 
	 * 
	 * @return
	 */
	public int maxLength(List<String> strings) {

		int maxLength = 0;
//		for (String s : strings) {
//			if (s.length() > maxLength) {
//				maxLength = s.length();
//			}
//		}
//		System.out.println(maxLength);

		maxLength = strings.stream().mapToInt(String::length).max().orElse(0);

		return maxLength;
	}

	public static void main(String[] args) {
		AddNumbers an = new AddNumbers();
		an.sumIt(1000000);

		an.maxLength(Arrays.asList("banana", "apple", "pear", "orange"));
	}
}
