package com.algorithm.throught.dynamicprogramming.double11;

/**
 * @author dongfengfeng on 2020-02-22
 */
public class Double11Solution {

    public void double11(int[] prices, int itemNum, int condition) {

        int maxValue = 2 * condition;
        boolean[][] status = new boolean[itemNum][maxValue];

        status[0][prices[0]] = true;

        for (int i=1; i<itemNum; i++) {
            for (int j=0; j<maxValue; j++) {
                if (status[i-1][j] == true) {
                    status[i][j] = true;
                }
            }
            for (int j=0; j<maxValue - prices[i]; j++) {
                if (status[i-1][j] == true) {
                    status[i][j+prices[i]] = true;
                }
            }
        }
        int minValue = 0;
        for (int i=condition; i<maxValue; i++) {
            if (status[itemNum-1][i] == true) {
                minValue = i;
                break;
            }
        }
        System.out.println("最低凑单额为:" + minValue);
        for (int i=itemNum-1; i>=0; i--) {
            if (minValue - prices[i]>=0 && status[i-1][maxValue-prices[i]] == true) {
                System.out.println("当前选择了价值：" + prices[i] + "的商品");
                minValue = minValue - prices[i];
            }
        }
    }
}
