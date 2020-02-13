package com.algorithm.base.sort;

/**
 * @author dongfengfeng on 2020-02-13
 */
public class CountkSort {

    private static final int SCOPE = 9;

    public void sort(int[] data) {

        int[] scopeArray = new int[SCOPE];
        for (int i=0; i<data.length; i++) {
            scopeArray[data[i] - 1] += 1;
        }
        int sum = 0;
        for (int i=0; i<scopeArray.length; i++) {
            sum += scopeArray[i];
            scopeArray[i] = sum;
        }

        int[] outArray = new int[data.length];

        for (int i=data.length - 1; i>0; i++) {
            int outIndex = data[i];
            outIndex -= 1;
            int countData = scopeArray[outIndex];
            outArray[countData - 1] = data[i];
            scopeArray[outIndex] = scopeArray[countData] - 1;
        }
        System.arraycopy(outArray, 0, data, 0, data.length);
    }
}
