package com.algorithm.throught.dynamicprogramming.trowEggs;

/**
 * @author dongfengfeng on 2020-03-15
 */
public class ThrowEggs {


    public int minThrowEgg(int floors, int eggs) {

        int[][] status = new int[eggs+1][floors+1];

        for (int i=0; i<=eggs; i++) {
            status[i][1] = 1;
            status[i][0] = 0;
        }

        for (int i=0; i<=floors; i++) {
            status[1][i] = i;
        }

        for (int i=2; i<=eggs; i++) {
            for (int j=2; i<=floors; j++) {
                status[i][j] = Integer.MAX_VALUE;
                for (int k=1; k<=j; k++) {
                    int tmp = Math.max(status[i][j-k], status[i-1][k-1]) + 1;
                    if (tmp < status[i][j]) {
                        status[i][j] = tmp;
                    }
                }
            }
        }
        return status[eggs][floors];
    }
}
