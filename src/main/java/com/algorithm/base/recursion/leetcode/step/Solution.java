package com.algorithm.base.recursion.leetcode.step;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dff on 2020-03-21
 */
public class Solution {
    Map<Integer, Integer> mem = new HashMap<>();
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (mem.containsKey(n)) {
            return mem.get(n);
        }
        int result = climbStairs(n - 1) + climbStairs(n - 2);
        mem.put(n, result);
        return result;
    }
}
