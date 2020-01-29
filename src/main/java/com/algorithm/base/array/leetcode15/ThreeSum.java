package com.algorithm.base.array.leetcode15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author dongfengfeng on 2020-01-29
 */
public class ThreeSum {

    public static ThreeSum INSTANCE = new ThreeSum();

    public List<List<Integer>> find(int[] arrays) {
        List<List<Integer>> result = new ArrayList<>();
        if (arrays == null || arrays.length < 3) {
            return null;
        }
        Arrays.sort(arrays);
        List<Integer> tmpList;
        HashSet<List<Integer>> hashSet = new HashSet<>();
        for (int i=0; i<arrays.length; i++) {
            int left = i+1;
            int right = arrays.length - 1;

            while (left < right) {
                if (arrays[i] + arrays[left] + arrays[right] == 0) {
                    tmpList = new ArrayList<>();
                    tmpList.add(arrays[i]);
                    tmpList.add(arrays[left]);
                    tmpList.add(arrays[right]);
                    if (!hashSet.contains(tmpList)) {
                        hashSet.add(tmpList);
                        result.add(tmpList);
                    }

                    left++;
                    right--;
                } else if (arrays[i] + arrays[left] + arrays[right] > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }
}
