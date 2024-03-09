package productofarryaexceptself238;

public class MaxWaterContainer {

	
	public int maxArea(int[] height) {
		
		int max = 0; 
		
		int left = 0;
		int right = height.length -1;
		
		int width = right-left;
		
		while(left < right) {
			int area = width * Math.min(height[left], height[right]);
			
			max = max > area ? max : area;
			
			if (height[left] <= height[right]  ) {
				left++;
			} else {
				right--;
			}
		}
		return max;
	}
}
