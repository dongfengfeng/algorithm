package com.algorithm.throught.backtracing.letterCombinations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dff on 2020-03-28
 */
public class Solution {
    List<String> result = new ArrayList<>();
    String[] dic = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return result;
        }
        char[] chars = digits.toCharArray();
        int[] digitChars = new int[chars.length];
        for (int i=0; i<digitChars.length; i++) {
            digitChars[i] = chars[i] - 48;
        }
        recursion(digitChars, 0, "");
        return result;
    }
    private void recursion(int[] digitChars, int n, String str) {
        if (n == digitChars.length) {
            result.add(str);
            return;
        }
        for (int i=0; i<dic[digitChars[n]].length(); i++) {
            str = str + dic[digitChars[n]].charAt(i);
            recursion(digitChars, n+1, str);
            str = str.substring(0, str.length() - 1);
        }
    }
}
