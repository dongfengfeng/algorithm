package com.algorithm.base.array.leetcode41;

import java.util.Arrays;

/**
 * @author dongfengfeng on 2020-01-29
 */
public class MinMissingNumber {

    public int find(int[] arrays) {
        if (arrays == null || arrays.length == 0) {
            return 1;
        }
        Arrays.sort(arrays);
        int[] indexArray = new int[arrays.length];
        for (int i=0; i<arrays.length; i++) {
            if (arrays[i] > 0 && arrays[i] < arrays.length) {
                indexArray[arrays[i]] = arrays[i];
            }
        }
        for (int i=1; i<indexArray.length; i++) {
            if (indexArray[i] == 0) {
                return i;
            }
        }
        return indexArray.length;
    }
}
