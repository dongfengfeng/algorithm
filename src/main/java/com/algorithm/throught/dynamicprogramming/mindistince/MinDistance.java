package com.algorithm.throught.dynamicprogramming.mindistince;

/**
 * 一个n*n的矩阵，求解最左上角到右下角的最短路径
 * @author dongfengfeng on 2020-02-22
 */
public class MinDistance {
    public int minDistance = Integer.MAX_VALUE;

    public void recursion(int[][] datas, int sumDis, int i, int j) {
        int length = datas.length - 1;
        if (i== length && j == length) {
            sumDis = sumDis + datas[i][j];
            if (minDistance < sumDis) {
                minDistance = sumDis;
            }
            return;
        }
        if (i != length) {
            recursion(datas, sumDis + datas[i][j], i+1, j);
        }
        if (j != length) {
            recursion(datas, sumDis + datas[i][j], i, j+1);
        }
    }

    private int[][] remarks;

    public void initArray(int i, int j) {
        remarks = new int[i][j];
    }

    public int recursion2(int[][] datas, int i, int j) {
        if (i == 0 && j == 0) {
            return datas[0][0];
        }
        if (remarks[i][j] > 0) {
            return remarks[i][j];
        }
        int leftMin = Integer.MAX_VALUE;
        if (j-1 >= 0) {
            leftMin = recursion2(datas, i, j-1);
        }
        int upMin = Integer.MAX_VALUE;
        if (i-1 >= 0) {
            upMin = recursion2(datas, i-1, j);
        }
        int minDistance = datas[i][j] + Math.min(leftMin, upMin);
        return minDistance;
    }

    public int dynamicDistince(int[][] datas) {
        int length = datas.length;
        int[][] status = new int[length][length];
        for (int i=0; i<length; i++) {
            for (int j=0; j<length; j++) {
                status[i][j] = -1;
            }
        }
        int sum = 0;
        for (int j=0; j<length; j++) {
            sum = sum + datas[0][j];
            status[0][j] = sum;
        }
        sum = 0;
        for (int i=0; i<length; i++) {
            sum = sum + datas[i][0];
            status[i][0] = sum;
        }

        for (int i=1; i<length; i++) {
            for (int j=1; j<length; j++) {
                status[i][j] = datas[i][j] + Math.min(status[i-1][j], status[i][j-1]);
            }
        }
        return status[length-1][length-1];
    }
}
