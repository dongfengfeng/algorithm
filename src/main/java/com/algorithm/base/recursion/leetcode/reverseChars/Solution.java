package com.algorithm.base.recursion.leetcode.reverseChars;

/**
 * @author dongfengfeng on 2020-03-20
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse("hello world"));
    }
    /**
     * 递归解法
     * @param str
     * @return
     */
    public String reverse(String str) {
        char[] chars = str.toCharArray();
        recursion(chars, 0);
        return String.valueOf(chars);
    }

    private void recursion(char[] chars, int index) {
        if (index == chars.length / 2) {
            return;
        }
        char tmp = chars[index];
        chars[index] = chars[chars.length - 1 - index];
        chars[chars.length - 1 - index] = tmp;
        recursion(chars, index + 1);
    }

    /**
     * 非递归解法
     * @param s
     * @return
     */
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        int i;
        char tmp;
        for (i=0; i<chars.length/2; i++) {
            tmp = chars[i];
            chars[i] = chars[chars.length - i - 1];
            chars[chars.length - i -1] = tmp;
        }
        return new String(chars);
    }

}
