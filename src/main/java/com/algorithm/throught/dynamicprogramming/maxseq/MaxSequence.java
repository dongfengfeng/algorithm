package com.algorithm.throught.dynamicprogramming.maxseq;

/**
 * @author dongfengfeng on 2020-02-21
 */
public class MaxSequence {
    public int maxSeq = Integer.MIN_VALUE;

    /**
     * 回朔
     * @param datas
     * @param index
     * @param sumSeq
     */
    public void countMaxSubSeq(int[] datas, int index, int sumSeq) {
        if (index == datas.length - 1) {
            if (maxSeq < sumSeq) {
                maxSeq = sumSeq;
            }
            return;
        }
        for (int i=index+1; i<datas.length; i++) {
            if (datas[index] < datas[i]) {
                countMaxSubSeq(datas, index + 1, sumSeq + 1);
            } else {
                countMaxSubSeq(datas, index + 1, sumSeq);
            }
        }
    }

    /**
     * 动态规划
     * @param datas
     * @return
     */
    public int countMaxSubSeq(int[] datas) {
        int[] status = new int[datas.length];
        status[0] = 1;

        int maxSeq = 0;
        for (int i=1; i<datas.length; i++) {
            int max = 0;
            for (int j=0; j<i; j++) {
                if (datas[j] < datas[i]) {
                    if (max < status[j]) {
                        max = status[j];
                    }
                }
            }
            status[i] = max + 1;
            if (status[i] > maxSeq) {
                maxSeq = status[i];
            }
        }
        return maxSeq;
    }
}
