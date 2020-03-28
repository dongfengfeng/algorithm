package com.algorithm.base.number.titleToNumber;

/**
 * @author dff on 2020-03-28
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.titleToNumber("AA");
    }
    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        if (chars.length == 1) {
            return chars[0] - 64;
        }
        int num = chars[chars.length-1] - 64;
        int mul = 1;
        for (int i=chars.length-2; i>=0; i--) {
            mul = mul * 26;
            num += (chars[i] - 64) * mul;
        }
        return num;
    }
}
