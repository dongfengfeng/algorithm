package com.algorithm.base.sort.leetcode.sortColors;

/**
 * @author dff on 2020-03-26
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1,2,0};
        solution.sortColors2(arr);
    }
    /**
     * 123123
     * @param nums
     */
    public void sortColors(int[] nums) {
        for (int i=0; i<nums.length - 1; i++) {
            int j = i;
            while (j < nums.length) {
                if (nums[j] == i%3) {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                    break;
                } else {
                    j++;
                }
            }
        }
    }

    /**
     * 112233
     * @param nums
     */
    public void sortColors2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int tmp;
        for (int i=0; i<nums.length; i++) {
            if (left >= right || i> right) {
                break;
            }
            if (nums[i] == 0) {
                tmp = nums[i];
                nums[i] = nums[left];
                nums[left++] = tmp;
            } else if (nums[i] == 2) {
                tmp = nums[i];
                nums[i] = nums[right];
                nums[right--] = tmp;
                i--;
            }
        }
    }
}
