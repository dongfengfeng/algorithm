package com.algorithm.throught.backtracing.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dff on 2020-03-29
 */
public class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Solution solution = new Solution();
        solution.subsets(nums);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subList = new ArrayList<>();
        recursion(0, nums, subList);
        return result;
    }
    private void recursion(int index, int[] nums, List<Integer> subList) {
        result.add(new ArrayList<>(subList));
        for (int i=index; i<nums.length; i++) {
            subList.add(nums[i]);
            recursion(i + 1, nums, subList);
            subList.remove(subList.size() - 1);
        }
    }
}
