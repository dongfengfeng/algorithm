package com.algorithm.base.other.leastInterval;

import java.util.Arrays;

/**
 * @author dff on 2020-03-27
 */
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] times = new int[26];
        for(char ch : tasks) {
            times[ch-'A']++;
        }
        Arrays.sort(times);
        int i = 25;
        while(i>=0 && times[i]==times[25]) {
            i--;
        }
        return Math.max(tasks.length,(times[25]-1)*(n+1)+25-i);
    }
}
