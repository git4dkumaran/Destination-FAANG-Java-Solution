package leet.indexhash;

import java.util.PriorityQueue;

public class MedianOfTwoArray {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {

		int i;
		int n = nums1.length;
		int m = nums2.length;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		for (i = 0; i < n; i++) {
			pq.add(nums1[i]);
		}
		for (i = 0; i < m; i++) {
			pq.add(nums2[i]);
		}

		int mergedSize = n + m;
		boolean isEven = (mergedSize % 2) == 0;
		
		int evenIndex1 = mergedSize / 2 ;
		int evenIndex2 = mergedSize / 2 + 1;
		double evenindexValue1 = 0, evenindexValue2 = 0;

		int oddIndex = mergedSize / 2 + 1;

		double count = 0;
		System.out.println( " mergedSize " + mergedSize + " isEven " + isEven + " evenIndex1 " + evenIndex1 + " evenIndex2  " +  evenIndex2 + " oddIndex " +  oddIndex );

		while (!pq.isEmpty()) {
			count++;

			if (isEven) {
				if (count == evenIndex1) {
					System.out.println( isEven  +" -->  evenIndex1 " + count + " --> " + pq.peek());
					evenindexValue1 = pq.peek();
				}
				if (count == evenIndex2) {
					evenindexValue2 = pq.peek();
					System.out.println( isEven  +" --> evenIndex2 " + count + " --> " + pq.peek());
					double ans = new Double((evenindexValue1 + evenindexValue2) / 2).doubleValue();
					return ans;
				}
			} else {
				if (count == oddIndex) {
					System.out.println(  isEven  +" --> " + count + " --> "  + pq.peek());
					return pq.peek();
				}
			}
			System.out.println(  isEven  +" --> " + count + " --> "  + pq.poll());

		}
		return 0.00000;
	}

	// Driver code
	public static void main(String[] args) {
		int[] arr1 = { -2, 3, 4, 5 };

		int[] arr2 = { -4, -1, 7, 8, 9 };

		MedianOfTwoArray median = new MedianOfTwoArray();
		System.out.println("Median of the two arrays are");
		System.out.println(median.findMedianSortedArrays(arr1, arr2));
		
		
		int[] arr3 = { -2, 3, 4, 13, 20 };
		System.out.println("  \n \n Median of the two arrays are ");
		System.out.println(median.findMedianSortedArrays(arr3, arr2));
		
	}

}
