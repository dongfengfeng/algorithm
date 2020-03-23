package com.algorithm.base.array.longestPalindrome;

/**
 * @author dff on 2020-03-23
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.longestPalindrome("babad");
    }
    public String longestPalindrome(String s) {
        if (s.length() < 1) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int max = 0;
        int index = 0;
        for (int i=0; i<chars.length; i++) {
            int left = i;
            int right = i+1;
            int tmpMax = 0;
            while (left >= 0 && right < chars.length) {
                if (chars[left] == chars[right]) {
                    tmpMax += 2;
                    left--;
                    right++;
                } else {
                    break;
                }
            }
            if (tmpMax > max) {
                max = tmpMax;
                index = i;
            }
        }
        for (int i=1; i<chars.length; i++) {
            int left = i-1;
            int right = i+1;
            int tmpMax = 1;
            while (left >= 0 && right < chars.length) {
                if (chars[left] == chars[right]) {
                    tmpMax += 2;
                    left--;
                    right++;
                } else {
                    break;
                }
            }
            if (tmpMax > max) {
                max = tmpMax;
                index = i;
            }
        }
        int start = index - (max - 1) / 2;
        int end = index + max / 2;

        return s.substring(start, end);
    }
}
