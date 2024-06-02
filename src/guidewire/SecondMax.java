package guidewire;

import org.junit.Assert;
import org.junit.Test;

public class SecondMax {

	public int findSecondHighestIndex(int[] nums) {
		if (nums.length < 2) {
			return -1;
		}

		int max = Integer.MIN_VALUE;
		int index1 = -1;

		int max2 = 0;
		int index2 = -1;

//{0,0,0}))
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				max2 = max;
				index2 = index1;
				max = nums[i];
				index1 = i;
			} else {
				if (nums[i] > max2 && nums[i] != max) {
					max2 = nums[i];
					index2 = i;
				}
			}
		}
		return index2;
	}

	@Test
	public void testFindSecondHighestIndex() {
		// you can write to stdout for debugging purposes, e.g.
		System.out.println("This is a debug message");
		Assert.assertEquals(2, findSecondHighestIndex(new int[] { 1, 4, 3 }));

		Assert.assertEquals(-1, findSecondHighestIndex(new int[] { 0, 0, 0 }));

		Assert.assertEquals(-1, findSecondHighestIndex(new int[] { 0 }));

		Assert.assertEquals(-1, findSecondHighestIndex(new int[] {}));

		Assert.assertEquals(0, findSecondHighestIndex(new int[] { -4, -6, -1 }));

		Assert.assertEquals(2, findSecondHighestIndex(new int[] { 1, 4, 3, 3 })); // first occurance of 2nd largest
		System.out.println("All Success.. ");
	}
}
