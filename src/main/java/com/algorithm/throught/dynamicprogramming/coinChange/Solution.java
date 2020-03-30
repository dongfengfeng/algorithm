package com.algorithm.throught.dynamicprogramming.coinChange;

/**
 * @author dff on 2020-03-30
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for (int i=1; i<=amount; i++) {
            dp[i] = 999999;
            for (int j=0; j<coins.length; j++) {
                if (i < coins[j]) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
            }
        }
        return dp[amount] == 999999 ? -1 : dp[amount];
    }
}
