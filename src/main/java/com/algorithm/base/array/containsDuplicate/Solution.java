package com.algorithm.base.array.containsDuplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dff on 2020-03-22
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int i;
        for (i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }
        if (set.size() == nums.length) {
            return false;
        } else {
            return true;
        }
    }
}
