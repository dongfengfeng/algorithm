package com.algorithm.base.sort;

import java.util.Arrays;

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

        for (int i=data.length - 1; i>=0; i--) {
            int outIndex = data[i] - 1;
            int countData = scopeArray[outIndex];
            outArray[countData - 1] = data[i];
            scopeArray[outIndex] = scopeArray[outIndex] - 1;
        }
        System.arraycopy(outArray, 0, data, 0, data.length);
    }

    public static void main(String[] args) {
        int[] data = {5, 6, 8, 1, 9, 2, 2, 3, 5, 9};
        CountkSort countkSort = new CountkSort();
        countkSort.sort(data);
        System.out.println(Arrays.toString(data));
    }
}
