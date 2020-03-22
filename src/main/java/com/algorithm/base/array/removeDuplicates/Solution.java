package com.algorithm.base.array.removeDuplicates;

/**
 * @author dff on 2020-03-22
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int tmpIndex = 1;
        int i;
        for (i=1; i<nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                continue;
            }
            else {
                nums[tmpIndex] = nums[i];
                tmpIndex++;
            }
        }
        return tmpIndex;
    }
}
