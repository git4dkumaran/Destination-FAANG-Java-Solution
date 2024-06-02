package linkedin;

//Java program to sort Hashmap based on values

import java.lang.*;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;

public class SortMap {

	// function to sort hashmap based on values
	public static Map<String, Integer> sortByValue(HashMap<String, Integer> hm) {
		// Creating a list from elements of HashMap
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

		// Sorting the list using Collections.sort() method
		// using Comparator
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> object1, Map.Entry<String, Integer> object2) {
				return (object1.getValue()).compareTo(object2.getValue());
			}
		});

		// putting the data from sorted list back to hashmap
		//HashMap<String, Integer> result = new ConcurrentSkipListMap()<String, Integer>();
		Map<String, Integer> result = new ConcurrentSkipListMap();
		
		for (Map.Entry<String, Integer> me : list) {
			result.put(me.getKey(), me.getValue());
		}

		// returning the sorted HashMap
		return result;
	}

	// Driver Code
	public static void main(String[] args) {
		// creating object of HashMap class
		HashMap<String, Integer> hashmap = new HashMap<String, Integer>();

		// inserting key-value pair into hashmap
		hashmap.put("five", 5);
		hashmap.put("seven", 7);
		hashmap.put("three", 3);
		hashmap.put("nine", 9);
		hashmap.put("zero", 0);
		hashmap.put("eight", 8);

		// sorting the HashMap based on values
		Map<String, Integer> map = sortByValue(hashmap);

		// print the sorted hashmap(based on values)
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + ", Value : " + entry.getValue());
		}
	}
}