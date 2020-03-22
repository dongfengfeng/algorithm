package com.algorithm.base.array.plusOne;

/**
 * @author dff on 2020-03-22
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        boolean flag = true;
        int i;
        if (digits[digits.length-1] != 9) {
            digits[digits.length-1]++;
            return digits;
        }
        for (i=digits.length-1; i>=0; i--) {
            if (digits[i] == 9) {
                if (flag) {
                    digits[i] = 0;
                    flag = true;
                    if (i==0) {
                        int[] digits2 = new int[digits.length+1];
                        digits2[0] = 1;
                        return digits2;
                    }
                }
            } else {
                if (flag) {
                    digits[i]++;
                    flag = false;
                }
            }
        }
        return digits;
    }
}
