package com.algorithm.throught.dynamicprogramming.zoreonepackage;

/**
 * @author dongfengfeng on 2020-02-17
 */
public class DynamicProgrammingPackage {

    public int dynamicProgrammingPackage(int[] weights, int maxNum, int maxWeight) {
        boolean[][] status = new boolean[maxNum][maxWeight];
        status[0][0] = true;
        if (weights[0] < maxWeight) {
            status[0][weights[0]] = true;
        }

        for (int i=1; i<maxNum; i++) {
            for (int j=0; j<maxWeight; j++) {
                if (status[i-1][j]) {
                    status[i][j] = status[i-1][j];
                }
            }
            for (int j=0; j+weights[i]<maxWeight; j++) {
                if (status[i-1][j]) {
                    status[i][j+weights[i]] = true;
                }
            }
        }
        for (int k=maxWeight; k>0; k--) {
            if (status[maxNum-1][k]) {
                return k;
            }
        }
        return 0;
    }

//    public int dynamicProgrammingPackage2() {
//
//    }
}
