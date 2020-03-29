package com.algorithm.throught.dynamicprogramming.canJump;

/**
 * @author dff on 2020-03-29
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            if (i==0) {
                dp[i] = Math.max(0, i+nums[i]);
            } else {
                dp[i] = Math.max(dp[i-1], i+nums[i]);
            }
            if (dp[i] >= nums.length - 1) {
                return true;
            }
            if (dp[i] <= i){
                return false;
            }
        }
        return false;
    }
}
