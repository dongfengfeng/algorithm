package com.algorithm.throught.dynamicprogramming.charsmatch;

/**
 * @author dongfengfeng on 2020-02-22
 */
public class MaxCommonChars {
    public int maxChars = Integer.MIN_VALUE;

    /**
     * 回朔
     * @param src
     * @param target
     * @param i
     * @param j
     * @param sumValues
     */
    public void count(char[] src, char[] target, int i, int j, int sumValues) {
        int srcLen = src.length;
        int targetLen = src.length;
        if (i == srcLen || j == targetLen) {
            if (maxChars < sumValues) {
                maxChars = sumValues;
            }
            return;
        }
        
        if (src[i] == target[j]) {
            count(src, target, i+1, j+1, sumValues+1);
        } else {
            count(src, target, i+1, j, sumValues);
            count(src, target, i, j+1, sumValues);
            count(src, target, i+1, j+1, sumValues);
        }
    }

    /**
     * 动态规划
     * @param src
     * @param target
     * @return
     */
    public int count(char[] src, char[] target) {
        int srcLen = src.length;
        int targetLen = src.length;
        int[][] status = new int[srcLen][targetLen];
        for (int i=0; i<srcLen; i++) {
            if (src[i] == target[0]) {
                status[i][0] = 1;
            }
        }
        for (int j=0; j<targetLen; j++) {
            if (src[0] == target[j]) {
                status[0][j] = 1;
            }
        }

        for (int i=1; i<srcLen; i++) {
            for (int j=1; j<targetLen; j++) {
                if (src[i] == target[j]) {
                    status[i][j] = max(status[i-1][j], status[i][j-1], status[i-1][j-1]+1);
                } else {
                    status[i][j] = max(status[i-1][j], status[i][j-1], status[i-1][j-1]);
                }
            }
        }
        return status[srcLen-1][targetLen-1];
    }

    private int max(int x, int y, int z) {
        int max = Integer.MIN_VALUE;

        if (x > max) {
            max = x;
        }
        if (y > max) {
            max = y;
        }
        if (z > max) {
            max = z;
        }
        return max;
    }
}
