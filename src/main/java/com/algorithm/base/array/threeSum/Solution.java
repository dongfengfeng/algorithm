package com.algorithm.base.array.threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dff on 2020-03-23
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] {-1,0,1,2,-1,-4};
        solution.threeSum(nums);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> subList;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    if (nums[i] + nums[left] > 0) {
                        break;
                    }
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    subList = new ArrayList<>();
                    subList.add(nums[i]);
                    subList.add(nums[left]);
                    subList.add(nums[right]);
                    resultList.add(subList);
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return resultList;
    }
}
