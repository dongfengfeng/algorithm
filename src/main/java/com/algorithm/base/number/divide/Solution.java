package com.algorithm.base.number.divide;

/**
 * @author dff on 2020-03-28
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        long m = Math.abs((long)dividend);
        long n = Math.abs((long)divisor);
        long count = 0;
        while (m >= n) {
            long tmp = n;
            long p = 1;
            while ((tmp<<1) < m) {
                tmp <<= 1;
                p <<= 1;
            }
            count += p;
            m -= tmp;
        }
        if ((dividend ^ divisor) < 0) {
            count = -count;
        }
        if (count > Integer.MAX_VALUE || count < Integer.MIN_VALUE){
            return Integer.MAX_VALUE;
        } else {
            return (int)count;
        }
    }
}
