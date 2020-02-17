package com.algorithm.throught.dynamicprogramming.zoreonepackagevalue;

/**
 * @author dongfengfeng on 2020-02-17
 */
public class DynamicProgrammingPackageValue {

    public int maxPackageValue(int[] weights, int[] values, int maxNum, int maxWeight) {
        int[][] valueStatus = new int[maxNum][maxWeight+1];
        for (int i=0; i<maxNum; i++) {
            for (int j=0; j<maxWeight; j++) {
                valueStatus[i][j] = -1;
            }
        }
        valueStatus[0][0] = 0;
        valueStatus[0][weights[0]] = values[0];

        for (int i=1; i<maxNum; i++) {
            for (int j=0; j<maxWeight; j++) {
                if (valueStatus[i-1][j] >= 0) {
                    valueStatus[i][j] = valueStatus[i-1][j];
                }
            }

            for (int j=0; j<maxWeight - weights[i]; j++) {
                if (valueStatus[i-1][j] >= 0) {
                    int tmpValue = valueStatus[i-1][j] + values[i];
                    if (tmpValue > valueStatus[i][j+weights[i]]) {
                        valueStatus[i][j+weights[i]] = tmpValue;
                    }
                }
            }
        }

        int result = -1;
        for (int i=0; i<maxWeight; i++) {
            if (valueStatus[maxNum-1][i] > result) {
                result = valueStatus[maxNum-1][i];
            }
        }
        return result;
    }
}
