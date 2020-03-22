package com.algorithm.base.array.moveZeroes;

/**
 * @author dff on 2020-03-22
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        int zeroNum = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                zeroNum++;
                continue;
            } else {
                nums[index++] = nums[i];
            }
        }
        for (int j=nums.length - 1; j > nums.length - 1 - zeroNum; j--) {
            nums[j] = 0;
        }
    }
}
