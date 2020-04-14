package com.algorithm.throught.dynamicprogramming.maxProduct;

/**
 * @author dff on 2020-04-14
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len+1];
        dp[0] = nums[0];
        int max = 1;
        for (int i=1; i<=len; i++) {
            for (int j=0; j<i; j++) {
                dp[i] = Math.max(dp[i-1], dp[i-1] * nums[j]);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
