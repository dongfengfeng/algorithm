package com.algorithm.base.recursion.leetcode.pow;

/**
 * @author dff on 2020-03-21
 */
public class Solution {
    /**
     * 递归解法
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            n = -n;
            x = 1/x;
        }
        double num = myPow(x, n/2);
        if (n / 2 == 0) {
            return num * num;
        } else {
            return num * num * x;
        }
    }

    /**
     * 非递归解法
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            n = -n;
            x = 1/x;
        }
        double num = 1;
        double cur = x;
        for (int i=n; i>0; i /=2) {
            if (n / 2 == 1) {
                num *= cur;
            }
            cur = cur * cur;
        }
        return num;
    }
}
