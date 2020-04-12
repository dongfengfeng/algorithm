package com.algorithm.throught.dynamicprogramming.maxProfit;

/**
 * @author dff on 2020-03-29
 */
public class Solution {
    /**
     * 多次买卖
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        for (int i=0; i<prices.length; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[prices.length-1][0];
    }

    /**
     * 多次买卖，有冻结期
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[len][3];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;

        for (int i=1; i<len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][2] - prices[i], dp[i-1][1]);
            dp[i][2] = dp[i-1][0];
        }
        return Math.max(dp[len-1][0], dp[len-1][2]);
    }

    /**
     * 多次买卖，有冻结期，dp数据压缩
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[][] dp = new int[2][3];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;

        for (int i=1; i<len; i++) {
            dp[i & 1][0] = Math.max(dp[i-1 & 1][0], dp[i-1 & 1][1] + prices[i]);
            dp[i & 1][1] = Math.max(dp[i-1 & 1][2] - prices[i], dp[i-1 & 1][1]);
            dp[i & 1][2] = dp[i-1 & 1][0];
        }
        return Math.max(dp[len-1 & 1][0], dp[len-1 & 1][2]);
    }

    /**
     * 多次买卖，有冻结期，dp一维数组
     * @param prices
     * @return
     */
    public int maxProfit4(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }
        int[] dp = new int[3];

        dp[0] = 0;
        dp[1] = -prices[0];
        dp[2] = 0;

        int sale = dp[0];
        int buy = dp[1];

        for (int i=1; i<len; i++) {
            dp[0] = Math.max(sale, buy + prices[i]);
            dp[1] = Math.max(sale - prices[i], buy);
            dp[2] = sale;

            sale = dp[0];
            buy = dp[1];
        }
        return Math.max(dp[0], dp[2]);
    }
}
