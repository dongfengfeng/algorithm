package com.algorithm.base.sort.leetcode.merge;

/**
 * @author dff on 2020-03-26
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ints = new int[][]{{1,4},{5,6}};
        solution.merge(ints);
    }

    /**
     * 未通过
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        int i = 0;
        int j = 1;
        int[][] result = new int[intervals.length][2];
        result[0] = intervals[0];
        while (i < result.length && j < intervals.length) {
            if (result[i][1] >= intervals[j][1]) {
                i++;
                j++;
            } else if (result[i][1] >= intervals[j][0]) {
                result[i++][1] = intervals[j++][1];
            } else {
                result[i++] = intervals[j++];
            }
        }
        int[][] r = new int[i][2];
        for (int k = 0; k < i; k++) {
            r[k] = result[k];
        }
        return r;
    }
}
