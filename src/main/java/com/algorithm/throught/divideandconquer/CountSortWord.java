package com.algorithm.throught.divideandconquer;

/**
 * @author dongfengfeng on 2020-02-16
 */
public class CountSortWord {

    private int num;

    public void countSort(int[] datas, int start, int end) {
        if (start > end) {
            return;
        }
        int mid = (start + end) / 2;
        countSort(datas, start, mid);
        countSort(datas, mid + 1, end);
        merge(datas, start, mid, end);
    }

    private void merge(int[] datas, int start, int mid, int end) {
        int[] result = new int[end - start];
        int left = start; int right = end;

        int resultIndex = 0;
        while (left <= mid && right <= end) {
            if (datas[left] >= datas[right]) {
                result[resultIndex++] = datas[right++];
                num++;
            } else {
                result[resultIndex++] = datas[left++];
            }
        }
        while (left <= mid) {
            result[resultIndex++] = datas[left++];
        }
        while (right <= end) {
            result[resultIndex++] = datas[right++];
        }

        for (int i=start; i<end; i++) {
            datas[i] = result[i - start];
        }
    }
}
