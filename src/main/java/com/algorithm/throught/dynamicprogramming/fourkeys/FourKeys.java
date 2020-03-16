package com.algorithm.throught.dynamicprogramming.fourkeys;

/**
 * @author dongfengfeng on 2020-03-16
 */
public class FourKeys {

    public int copy(int n) {
        int[] status = new int[n+1];

        status[0] = 1;
        for (int i=1; i<=n; i++) {
            status[i] = status[i-1] + 1;
            for (int j=2; j<i; j++) {
                status[i] = Math.max(status[i], status[j-2]*(i-j+1));
            }
        }
        return status[n];
    }
}
