package com.algorithm.throught.backtracing.zeroonepackage;

/**
 * @author dongfengfeng on 2020-02-16
 */
public class PackageValue {
    private int maxWeight;
    private int maxValue;

    public PackageValue(int maxWeight, int maxValue) {
        this.maxWeight = maxWeight;
        this.maxValue = maxValue;
    }
    public void getMaxPackage(int index, int sumWeight, int sumValue, Package[] datas, int maxNum, int curMaxWeight) {
        if (index == curMaxWeight || curMaxWeight == maxWeight) {
            if (sumWeight > maxWeight) {
                maxWeight = sumWeight;
            }
            if (sumValue > maxValue) {
                maxValue = sumValue;
            }
            return;
        }
        getMaxPackage(index + 1, sumWeight, sumValue, datas, maxNum, curMaxWeight);
        if (sumWeight + datas[index].getWeight() < maxWeight) {
            getMaxPackage(index + 1,
                    sumWeight + datas[index].getWeight(),
                    sumValue + datas[index].getValue(),
                    datas, maxNum, curMaxWeight);
        }
    }
}
