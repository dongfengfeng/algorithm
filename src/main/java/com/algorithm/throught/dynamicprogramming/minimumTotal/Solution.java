package com.algorithm.throught.dynamicprogramming.minimumTotal;

import java.util.List;

/**
 * @author dff on 2020-04-14
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] dp = new int[size+1];
        for (int i=size-1; size>=0; i--) {
            for (int j=0; j<i; j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
