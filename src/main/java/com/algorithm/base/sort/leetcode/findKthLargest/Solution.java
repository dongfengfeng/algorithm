package com.algorithm.base.sort.leetcode.findKthLargest;

/**
 * @author dff on 2020-03-26
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{3,2,1,5,6,4};
        solution.findKthLargest(arr, 2);
    }
    public int findKthLargest(int[] nums, int k) {
        int tmp;
        for (int i=nums.length - 1; i>=nums.length - k; i--) {
            for (int j=0; j<i; j++) {
                if (nums[j] > nums[i]) {
                    tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
        return nums[nums.length-k];
    }
}
