package com.algorithm.throught.backtracing.generateParenthesis;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dff on 2020-03-28
 */
public class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return result;
        }
        recusion(n, n, "");
        return result;
    }
    private void recusion(int left, int right, String str) {
        if (left < 0 || right < 0 || left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            result.add(str);
            return;
        }
        recusion(left - 1, right, str + "(");
        recusion(left, right - 1, str + ")");
    }
}
