package com.algorithm.base.recursion.leetcode.kchar;

/**
 * @author dff on 2020-03-21
 */
public class Solution {

    private int count = 0;

    public int kthGrammar(int N, int K) {
        if (N == 1) return 0;
        return (~K & 1) ^ kthGrammar(N-1, (K+1)/2);
    }

    /**
     * 正常思维，不过时间超限
     * @param N
     * @param K
     * @return
     */
    public int kthGrammar2(int N, int K) {
        char[] result = new char[1];
        recursion("0", N, K, result);
        return result[0] - 48;
    }
    private void recursion(String str, int N, int K, char[] result) {
        count++;
        if (count == N) {
            result[0] = str.charAt(K - 1);
        }
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<str.length(); i++) {
            if ((str.charAt(i) + "").equals("0")) {
                sb.append("01");
            } else if ((str.charAt(i) + "").equals("1")) {
                sb.append("10");
            }
        }
        recursion(sb.toString(), N, K, result);
    }
}
