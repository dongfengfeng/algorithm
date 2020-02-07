package com.algorithm.base.recursion;

/**
 * @author dongfengfeng on 2020-02-07
 */
public class RecursionNotStep {

    public int step(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int curStep = 2;
        int preStep = 1;
        int tmpStep = 0;
        for (int i=3; i<=n; i++) {
            tmpStep = curStep + preStep;
            preStep = curStep;
            curStep = tmpStep;
        }
        return tmpStep;
    }
}
