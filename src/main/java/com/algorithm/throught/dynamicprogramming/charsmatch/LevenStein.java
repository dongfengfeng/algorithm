package com.algorithm.throught.dynamicprogramming.charsmatch;

/**
 * 莱文斯坦
 * @author dongfengfeng on 2020-02-22
 */
public class LevenStein {
    public int minLength = Integer.MAX_VALUE;

    /**
     * 回朔
     * @param src
     * @param target
     * @param step
     * @param i
     * @param j
     */
    public void count(char[] src, char[] target, int step, int i, int j) {
        int srcLen = src.length;
        int targetLen = target.length;
        if (i == srcLen || j == targetLen) {
            if (i < srcLen) {
                step = step + (srcLen - i);
            }
            if (j < targetLen) {
                step = step + (targetLen - j);
            }
            if (minLength > step) {
                minLength = step;
            }
            return;
        }

        if (src[i] == target[j]) {
            count(src, target, step, i+1, j+1);
        } else {
            count(src, target, step+1, i+1, j);
            count(src, target, step+1, i, j+1);
            count(src, target, step+1, i+1, j+1);
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
        int targetLen = target.length;
        int[][] status = new int[srcLen][targetLen];

        for (int i=0; i<srcLen; i++) {
            if (src[i] == target[i]) {
                status[0][i] = i;
            } else if(i != 0) {
                status[0][i] = status[0][i-1] + 1;
            } else {
                status[0][i] = 1;
            }
        }
        for (int j=0; j<targetLen; j++) {
            if (src[j] == target[j]) {
                status[j][0] = j;
            } else if(j != 0) {
                status[j][0] = status[j-1][0] + 1;
            } else {
                status[j][0] = 1;
            }
        }

        for (int i=1; i<srcLen; i++) {
            for (int j=1; j<targetLen; j++) {
                if (src[i] == target[j]) {
                    status[i][j] = min(status[i-1][j] + 1, status[i][j-1] + 1, status[i-1][j-1]);
                } else {
                    status[i][j] = min(status[i-1][j] + 1, status[i][j-1] + 1, status[i-1][j-1] + 1);
                }
            }
        }
        return status[srcLen-1][targetLen-1];
    }

    private int min(int x, int y, int z) {
        int min = Integer.MAX_VALUE;

        if (min > x) {
            min = x;
        }
        if (min > y) {
            min = y;
        }
        if (min > z) {
            min = z;
        }
        return min;
    }

}
