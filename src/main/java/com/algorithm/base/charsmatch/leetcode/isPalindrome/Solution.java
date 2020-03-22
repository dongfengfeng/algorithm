package com.algorithm.base.charsmatch.leetcode.isPalindrome;

/**
 * @author dff on 2020-03-22
 */
public class Solution {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        Solution solution = new Solution();
        solution.isPalindrome(s);
    }

    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!isNumberOrLetter(chars[left])) {
                left++;
                continue;
            }
            if (!isNumberOrLetter(chars[right])) {
                right--;
                continue;
            }
            if (chars[left] == chars[right] || (Character.isLetter(chars[left]) && Character.isLetter(chars[right])
                    && Math.abs(chars[left] - chars[right]) == 32)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
    private boolean isNumberOrLetter(char c) {
        if (Character.isDigit(c) || Character.isLetter(c)) {
            return true;
        }
        return false;
    }
}
