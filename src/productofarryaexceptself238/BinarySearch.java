package productofarryaexceptself238;

class BinarySearch {

	// search in rotated sorted array.
	
	public int search(int[] nums, int find) { 
        
        int resultindex = 1; 
        int l, r, m = 0;
        
        l = 0;
        r = nums.length -1;
        m = ( l + r ) / 2 ;
        
        for(int i=0; i<nums.length; i++){
        	System.out.println(" Left " + l +" Mid " + m + " Right " + r);
        	m = ( l + r ) / 2 ;
        	
        	
        	if (nums[m] == find  ) {
        		resultindex = l;
        		return resultindex;
        	} 
        	
        	if (nums[l] <= nums[r]) {
        		if (find < nums[l]  || find > nums[m]) {
        			l = m + 1; 
        		} else {
        			r = m - 1; 
        		}
        	} else {
        		if ( find > nums[r] ||  find < nums[m] ) {
        			r = m -1;
        		} else {
        			l = m + 1;
        		}
        	}
        	
        	
        }
        	
        return -1;
    }

	public static void main(String[] args) {
    	int[] input = {3,4,5,7,9,0,1,2};
    	
    	BinarySearch s = new BinarySearch();
    	int out = s.search(input,0);
    	
    	System.out.println(out );
	}
}