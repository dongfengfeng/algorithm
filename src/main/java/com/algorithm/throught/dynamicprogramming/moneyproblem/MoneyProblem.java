package com.algorithm.throught.dynamicprogramming.moneyproblem;

/**
 * @author dongfengfeng on 2020-02-18
 */
public class MoneyProblem {
    private int minNum = -1;

    public int minNumMoney(int[] moneys, int sumMoney, int sumNum, int maxMoney) {
        if (sumMoney == maxMoney) {
            return sumNum;
        }

        for (int i=0; i<moneys.length; i++) {
            if (sumMoney + moneys[i] <=maxMoney) {
                int num = minNumMoney(moneys, sumMoney + moneys[i], sumNum + 1, maxMoney);
                if (minNum == -1) {
                    minNum = num;
                } else if (minNum > num){
                    minNum = num;
                }
            }
        }
        return minNum;
    }
}
