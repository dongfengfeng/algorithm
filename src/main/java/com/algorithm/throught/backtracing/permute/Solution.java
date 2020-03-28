package com.algorithm.throught.backtracing.permute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dff on 2020-03-28
 */
public class Solution {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        fullSort(nums, 0, nums.length-1);
        return result;
    }
    public void fullSort(int[] arr, int start, int end) {
        // 递归终止条件
        if (start == end) {
            List<Integer> subList = new ArrayList<>();
            for (int i=0; i<arr.length; i++) {
                subList.add(arr[i]);
            }
            result.add(subList);
            return;
        }
        for (int i = start; i <= end; i++) {
            swap(arr, i, start);
            fullSort(arr, start + 1, end);
            swap(arr, i, start);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
