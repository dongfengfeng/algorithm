package com.algorithm.base.array.rotate;

/**
 * @author dff on 2020-03-22
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        if (k > nums.length) {
            k = k - nums.length;
        }
        int[] tmp = new int[k];
        for(int i=0; i<k; i++) {
            tmp[i] = nums[nums.length - i - k];
            nums[i] = tmp[i];
        }
        for (int i=nums.length - 1; i>=k; i--) {
            if (i>k && i<2*k-1) {
                nums[i] = tmp[i-k];
            } else {
                nums[i] = nums[i-k];
            }
        }
    }
}
