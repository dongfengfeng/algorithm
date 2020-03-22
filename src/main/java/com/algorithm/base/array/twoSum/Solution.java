package com.algorithm.base.array.twoSum;

/**
 * @author dff on 2020-03-22
 */
public class Solution {
    /**
     * 暴力解法，可使用排序数组双指针方式优化
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int i;
        int n = 0;
        int[] result = new int[2];
        for (i=0; i<nums.length-1; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (n == i && i != 0) {
                    continue;
                } else {
                    if(target == nums[i] + nums[j]) {
                        result[0] = i;
                        result[1] = j;
                        n = j;
                    }
                }
            }
        }
        return result;
    }
}
