package com.algorithm.base.recursion.leetcode.fibonacci;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dff on 2020-03-21
 */
public class Solution {
    Map<Integer, Integer> mem = new HashMap<>();
    public int fib(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        if (mem.containsKey(N)) {
            return mem.get(N);
        }
        int result = fib(N - 1) + fib(N - 2);
        mem.put(N, result);
        return result;
    }
}
