package leet.indexhash;

//https://leetcode.com/problems/binary-search/description/ 
public class BinarySearch {

	int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;

		int left = 0, right = nums.length - 1;
		while (left <= right) {
			// Prevent (left + right) overflow
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		// End Condition: left > right
		return -1;
	}

	public static void main(String[] args) {

		int[] nums = { -1, 0, 3, 5, 9, 12 };

		BinarySearch bs = new BinarySearch();
		System.out.println(" 9 exists in nums and its index is  " + bs.search(nums, 9));

		System.out.println(" 2 exists in nums and its index is  " + bs.search(nums, 2));

	}
}
