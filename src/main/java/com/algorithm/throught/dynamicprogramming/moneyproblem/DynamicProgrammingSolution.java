package com.algorithm.throught.dynamicprogramming.moneyproblem;

/**
 * @author dongfengfeng on 2020-02-18
 */
public class DynamicProgrammingSolution {

    public int countMinMoney(int[] moneyItems, int maxMoney) {
        if (moneyItems == null || moneyItems.length == 0) {
            return -1;
        }
        if (maxMoney <= 0) {
            return -1;
        }
        int level = maxMoney / moneyItems[0];
        int len = moneyItems.length;

        int[][] status = new int[level][maxMoney+1];

        for (int i=0; i<level; i++) {
            for (int j=0; j<maxMoney + 1; j++) {
                status[i][j] = -1;
            }
        }

        for (int i=0; i<len; i++) {
            status[0][moneyItems[i]] = moneyItems[i];
        }

        int minNum = -1;

        for (int i=0; i<level; i++) {
            for (int j=0; j<maxMoney; j++) {
                if (status[i-1][j] != -1) {
                    for (int k=0; k<len; k++) {
                        if (j + moneyItems[k] <= maxMoney) {
                            status[i][j+moneyItems[k]] = moneyItems[k];
                        }
                    }
                }
                if (status[i][maxMoney] >=0) {
                    minNum = i;
                    break;
                }
            }
            if (minNum > 0) {
                break;
            }
        }
        int beforeValue = maxMoney;

        for (int i=minNum; i>=0; i--) {
            for (int j=maxMoney; j>=0; j--) {
                if (j == beforeValue) {
                    System.out.println("当前输出" + j);
                    beforeValue = beforeValue - status[i][j];
                    break;
                }
            }
        }
        return minNum;
    }
}
