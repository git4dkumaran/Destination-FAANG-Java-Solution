//https://leetcode.com/problems/top-k-frequent-elements/description/
/**
 * \Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 */

package leet.indexhash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements {

	
	    public int[] topKFrequentLeed(int[] nums, int k) {
	        // O(1) time
	        if (k == nums.length) {
	            return nums;
	        }
	        
	        // 1. Build hash map: character and how often it appears
	        // O(N) time
	        Map<Integer, Integer> count = new HashMap();
	        for (int n: nums) {
	          count.put(n, count.getOrDefault(n, 0) + 1);
	        }

	        // init heap 'the less frequent element first'
	        Queue<Integer> heap = new PriorityQueue<>(
	            (n1, n2) -> count.get(n1) - count.get(n2));

	        // 2. Keep k top frequent elements in the heap
	        // O(N log k) < O(N log N) time
	        for (int n: count.keySet()) {
	          heap.add(n);
	          if (heap.size() > k) heap.poll();    
	        }

	        // 3. Build an output array
	        // O(k log k) time
	        int[] top = new int[k];
	        for(int i = k - 1; i >= 0; --i) {
	            top[i] = heap.poll();
	        }
	        return top;
	    }
	
	public int[] topKFrequent(int[] nums, int k) {

		if (nums.length == 1) {
			return nums;
		}
		
		Arrays.sort(nums);
		int i = 0, j = 0;
		int count = 0;
		List<Integer> frequent = new ArrayList<>();
		while (i < nums.length-1) {
			count = 1;
			j = i + 1;
			while (j < nums.length && nums[i] == nums[j]) {
				count++;
				j =  j +1;
			}
			if (count >= k) {
				frequent.add(nums[i]);
			}
			i = j;
		}

		int[] arr = frequent.stream().mapToInt(Integer::intValue).toArray();
		return arr;
	}
	
	

	public static void main(String[] args) {

		int[] data1 = { 1, 1, 1, 2, 2, 3 };
		TopKFrequentElements ga = new TopKFrequentElements();

		//int[] a = ga.topKFrequent(data1, 2);
		int[] a = ga.topKFrequentLeed(data1, 2);
		
		
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

		int[] data2 = { 1 };

		//a = ga.topKFrequent(data2, 1);
		
		a = ga.topKFrequentLeed(data2, 1);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
		int[] data3 = {-1,-1};
		
		//a = ga.topKFrequent(data3, 1);
		a = ga.topKFrequentLeed(data3, 1);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
		System.out.println(" Final Data ");
		int[] data4 = {1,2};
		a = ga.topKFrequentLeed(data4, 2);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

}
