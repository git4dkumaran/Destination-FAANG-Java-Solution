package meta;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

public class MockIV {

	// Swap zero's to the right and return
	// [3,0,0,7,0,2,5,6] == [3,7,2,5,6,?,?,?]
	public int[] swapNonZero(int[] nums) {

		if (nums.length <= 1)
			return nums;

		int count = -1;

		int left = 0;
		int right = nums.length - 1;

		while (left < right) {

			if (nums[left] == 0) {
				while (right > left) {
					if (nums[right] != 0) {
						int temp = nums[right];
						nums[right] = nums[left];
						nums[left] = temp;
						break;
					}
					right--;
				}
			}

			left++;
		}

		// int[] intArray = { 1, 2, 3, 4, 5 };
		IntStream intStream = Arrays.stream(nums);

		System.out.println(Arrays.stream(nums).mapToObj(Integer::toString)
				// .toArray(String[]::new);
				.collect(Collectors.joining(", ")));

		// for()
		// System.out.println ( Arrays.deepToString(nums));
		return nums;
	}

	// src == facebook, target = 'boo' return = 1;
	// src == facebook, target = 'ooook' return = 2;
	// src == facebook, target = 'Zoo Keeper' return = -1; --
	public int countStickersRequired(String src, String target) {
		int count = -1;

		if (src.isBlank() || target.isBlank()) {
			return -1;
		}

		Map<Character, Integer> srcChar = new HashMap<Character, Integer>();
		Map<Character, Integer> targetChar = new HashMap<Character, Integer>();

		for (int i = 0; i < src.length(); i++) {
			if (srcChar.get(src.charAt(i)) == null) {
				srcChar.put(src.charAt(i), 1);
			} else {
				srcChar.put(src.charAt(i), srcChar.get(src.charAt(i)) + 1);
			}
		}

		for (int i = 0; i < target.length(); i++) {
			if (srcChar.get(target.charAt(i)) == null) {
				return -1;
			} else {
				srcChar.put(target.charAt(i), srcChar.get(target.charAt(i)) - 1);
			}
		}

		int min = 1;

		for (Map.Entry<Character, Integer> entry : srcChar.entrySet()) {
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			if (min > entry.getValue()) {
				min = entry.getValue();
			}
		}

		return min;
	}

	public static void main(String[] args) {

		MockIV iv = new MockIV();

		iv.swapNonZero(new int[] { 1, 0, 4, 7, 0, 34, 0, 0, 3 });

		iv.swapNonZero(new int[] { 1, 0, 0, 0, 0, 34, 0, 0, 3 });

		iv.swapNonZero(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });

		iv.swapNonZero(new int[] { -1, 0, 0, 0, -2, -345, 876 });
		
		
		
		//System.out.println( " "+ iv.countStickersRequired("facebook", "boo") );

		System.out.println( " "+ iv.countStickersRequired("facebook", "boobooo") );
		
		System.out.println( " "+ iv.countStickersRequired("facebook", "sldfjlsdfj") );
		
	}

	@Test
	public void testFindSecondHighestIndex() {
		// you can write to stdout for debugging purposes, e.g.
		System.out.println("This is a debug message");
		Assert.assertEquals(new int[] { 1, 3, 4, 7, 34, 0, 0, 0, 0 },
				swapNonZero(new int[] { 1, 0, 4, 7, 0, 34, 0, 0, 3 }));

		Assert.assertEquals(new int[] { 1, 34, 3, 0, 0, 0, 0, 0, 0 },
				swapNonZero(new int[] { 1, 0, 0, 0, 0, 34, 0, 0, 3 }));

		Assert.assertEquals(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
				swapNonZero(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }));

		System.out.println("All Success.. ");
	}
}
