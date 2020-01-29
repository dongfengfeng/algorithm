package com.algorithm.base.array.leetcode169;

/**
 * @author dongfengfeng on 2020-01-29
 */
public class Majority {

    public int find(int[] arrays) {
        int tmp = arrays[0];
        int vote = 1;
        for (int i=0; i<arrays.length; i++) {
            if (vote == 0) {
                tmp = arrays[i];
            } else if (arrays[i] == vote) {
                vote++;
            } else {
                vote--;
            }
        }
        return tmp;
    }
}
