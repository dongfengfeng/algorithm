package com.algorithm.base.charsmatch.myAtoi;

/**
 * @author dff on 2020-03-22
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //超出long值范围，出错
        solution.myAtoi("-9223372036854775808");
    }
    public int myAtoi(String str) {
        str = str.trim();
        if ("".equals(str) || "-".equals(str) || "+".equals(str)) {
            return 0;
        }
        char[] chars = str.toCharArray();
        if (!Character.isDigit(chars[0]) && chars[0] != '-' && chars[0] != '+') {
            return 0;
        }
        int index = 0;
        if (chars[0] == '-' || chars[0] == '+') {
            if (!Character.isDigit(chars[1])) {
                return 0;
            }
            index = 1;
        }
        long sum = 0;
        while (index < chars.length && Character.isDigit(chars[index])) {
            sum = sum * 10 + chars[index++] - 48;
        }
        if (chars[0] == '-') {
            if (sum > Integer.MAX_VALUE) {
                sum = Integer.MIN_VALUE;
            } else {
                sum = -sum;
            }
        } else {
            if (sum > Integer.MAX_VALUE) {
                sum = Integer.MAX_VALUE;
            }
        }
        return Integer.parseInt(String.valueOf(sum));
    }
}
