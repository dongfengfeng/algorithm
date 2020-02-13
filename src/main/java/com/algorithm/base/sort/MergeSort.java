package com.algorithm.base.sort;

import java.lang.reflect.Array;

/**
 * @author dongfengfeng on 2020-02-13
 */
public class MergeSort<T> implements Sort<T> {
    @Override
    public void sort(T[] data) {
        if (!validate(data)) {
            return;
        }
        mergeSort(data, 0, data.length - 1);
    }

    private void mergeSort(T[] data, int left, int right) {
        int mid = left + (right - left) / 2;

        mergeSort(data, left, mid);
        mergeSort(data, mid+1, right);
        merge(data, left, mid, mid+1, right);
    }

    private void merge(T[] data, int lefts, int lefte, int rights, int righte) {
        int leftIndex = lefts;
        int rightIndex = rights;
        T[] targets = (T[])Array.newInstance(data[0].getClass(), righte - lefts);
        int targetIndex = 0;

        while (leftIndex <= lefte && rightIndex <= righte) {
            if (((Comparable)data[leftIndex]).compareTo(data[rightIndex]) > 0) {
                targets[targetIndex++] = data[rightIndex++];
            } else {
                targets[targetIndex++] = data[leftIndex++];
            }
        }
        if (leftIndex < lefte) {
            for (int i=leftIndex; i<lefte; i++) {
                targets[targetIndex++] = data[i];
            }
        } else if (rightIndex < righte) {
            for (int i=rightIndex; i<righte; i++) {
                targets[targetIndex++] = data[i];
            }
        }
        for (int i=lefts; i<righte; i++) {
            data[i] = targets[i - lefts];
        }
    }
}
