package com.algorithm.base.number.trailingZeroes;

/**
 * @author dff on 2020-03-28
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.trailingZeroes(30);
    }

    /**
     * 该算法当n较大时，n!的结果超限，有问题
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        if (n == 0) {
            return 0;
        }
        long mul = recursion(n);
        int count = 0;
        while (mul > 0 && mul % 10 == 0) {
            mul /= 10;
            count++;
        }
        return count;
    }
    private long recursion(int n) {
        if (n == 1) {
            return 1;
        }
        return n * recursion(n - 1);
    }

    public int trailingZeroes2(int n) {
        int count = 0;
        while (n > 0) {
            count += (n /= 5);
        }
        return count;
    }
}
