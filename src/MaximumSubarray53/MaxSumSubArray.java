package MaximumSubarray53;

public class MaxSumSubArray {

	public int maxSubArray (int[] nums) {
	
		
		int maxSum = nums[0];

		int currSum = nums[0];
		
		for(int i = 0 ; i < nums.length; i++) {
		
			if (currSum < 0) currSum = 0;
			
			currSum = currSum + nums[i];
			maxSum = currSum > maxSum ? currSum : maxSum;
		}
		
		return maxSum;
		
	}
	
	public static void main(String[] args) {
		
	}
}
