package com.algorithm.base.recursion;

/**
 * @author dongfengfeng on 2020-02-07
 */
public class RecursionStep {
    private int count;
    public int step(int n) {
        count++;
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return step(n - 1) + step(n - 2);
    }
}
