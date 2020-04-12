package com.algorithm.throught.dynamicprogramming.divisorGame;

/**
 * @author dff on 2020-04-12
 */
public class Solution {
    public boolean divisorGame(int N) {
        if (N == 1) {
            return false;
        }
        if (N == 2) {
            return true;
        }
        boolean[] dp = new boolean[N+1];
        dp[1] = false;
        dp[2] = true;
        for (int i=3; i<=N; i++) {
            dp[i] = false;
            for (int j=1; j<i; j++) {
                if (i % j == 0 && !dp[i-j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[N];
    }

    public boolean divisorGame2(int N) {
        return N % 2 == 0;
    }
}
