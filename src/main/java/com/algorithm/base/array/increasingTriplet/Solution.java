package com.algorithm.base.array.increasingTriplet;

/**
 * @author dff on 2020-03-24
 */
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++) {
            if (first > nums[i]) {
                first = nums[i];
            } else if (nums[i] > first && nums[i] < second) {
                second = nums[i];
            } else if (nums[i] > second){
                return true;
            }
        }
        return false;
    }
}

