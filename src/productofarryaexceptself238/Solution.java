package productofarryaexceptself238;

import java.util.Arrays;

class Solution {

	public int[] productExceptSelf(int[] nums) { 
        
        int [] result = new int[nums.length];
        
        Arrays.fill(result, 1);
        
        int preFix = 1; 
        
        for(int i=0; i<nums.length; i++){
            result[i] = preFix;
            preFix = preFix * nums[i];
        }
        
        int postFix = 1;
        for(int i=nums.length - 1; i>=0; i--){
            result[i] = postFix * result[i];
            postFix = postFix * nums[i];
        }
        
        return result;
    }

	public static void main(String[] args) {
    	int[] input = {1,2,3,4};
    	
    	Solution s = new Solution();
    	int[] out = s.productExceptSelf(input);
    	
    	for(int i = 0 ; i< out.length; i++) {
    		System.out.println(out[i]);
    	}
    	
	}
}