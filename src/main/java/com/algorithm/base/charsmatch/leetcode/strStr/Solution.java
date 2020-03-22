package com.algorithm.base.charsmatch.leetcode.strStr;

/**
 * @author dff on 2020-03-22
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String h = "mississippi";
        String n = "issip";
        solution.strStr(h, n);
    }
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        if (haystack.equals("") && !needle.equals("") || haystack.length() < needle.length()) {
            return -1;
        }
        char[] haystacks = haystack.toCharArray();
        char[] needles = needle.toCharArray();
        for (int i=0; i<haystacks.length; i++) {
            if (haystacks[i] == needles[0]) {
                int k = i;
                int index = 0;
                if (haystacks.length - k < needles.length) {
                    return -1;
                }
                while (k < haystacks.length && index < needles.length) {
                    if (haystacks[k] == needles[index]) {
                        k++;
                        index++;
                    } else {
                        break;
                    }
                }
                if (index == needles.length) {
                    return i;
                }
            }
        }
        return -1;
    }
}
