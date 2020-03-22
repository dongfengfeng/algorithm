package com.algorithm.base.array.singleNumber;

/**
 * @author dff on 2020-03-22
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int i;
        int num = 0;
        for (i=0; i<nums.length; i++) {
            num ^= nums[i];
        }
        return num;
    }
}
