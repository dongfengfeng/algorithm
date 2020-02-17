package com.algorithm.throught.dynamicprogramming.zoreonepackage;

/**
 * @author dongfengfeng on 2020-02-17
 */
public class BacktracingPackage {
    public int maxSumWeight = Integer.MIN_VALUE;

    private boolean[][] mem = new boolean[10][100];

    public void countPackage(int numIndex, int sumWeight, int[] datas, int maxNum, int maxWeight) {
        if (numIndex == maxNum || sumWeight == maxWeight) {
            if (sumWeight > maxSumWeight) {
                maxSumWeight = sumWeight;
            }
            return;
        }
        if (mem[numIndex][sumWeight]) {
            return;
        }
        mem[numIndex][sumWeight] = true;
        countPackage(numIndex + 1, sumWeight, datas, maxNum, maxWeight);
        if (sumWeight + datas[numIndex] < maxWeight) {
            countPackage(numIndex + 1, sumWeight + datas[numIndex], datas, maxNum, maxWeight);
        }
    }
}
