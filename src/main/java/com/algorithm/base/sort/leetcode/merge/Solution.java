package com.algorithm.base.sort.leetcode.merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dff on 2020-03-26
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ints = new int[][]{{1,3},{2,6},{8,10},{15,18}};
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
        List<int[]> tmp = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i<intervals.length-1 && intervals[i+1][0] <= right) {
                i++;
                right = Math.max(intervals[i][1], right);
            }
            tmp.add(new int[]{left, right});
            i++;
        }
        return tmp.toArray(new int[0][]);
    }
}
