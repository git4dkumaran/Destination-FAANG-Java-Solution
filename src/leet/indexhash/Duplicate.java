package leet.indexhash;

import java.util.HashSet;
import java.util.Set;

class Duplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> unique = new HashSet<Integer>();
        for(int i = 0 ; i< nums.length; i++) {
            if ( !unique.add(nums[i]) )
                return true;
        }
//
//
//        for(int i = 0 ; i< nums.length; i++) {
//            for (int j = i+1; j < nums.length; j++) {
//                if (nums[i] == nums[j]) {
//                    return true;
//                }
//            }
//        }
        return false;
    }
}
