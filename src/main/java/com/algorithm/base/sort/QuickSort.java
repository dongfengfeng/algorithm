package com.algorithm.base.sort;

/**
 * @author dongfengfeng on 2020-02-12
 */
public class QuickSort<T> implements Sort<T> {
    @Override
    public void sort(T[] data) {
        if (!validate(data)) {
            return;
        }
        quickSort(data, 0, data.length - 1);
    }

    private void quickSort(T[] data, int left, int right) {
        if (left < right) {
            int index = partition(data, left, right);

            quickSort(data, left, index - 1);
            quickSort(data, index + 1, right);
        }
    }

    private int partition(T[] data, int left, int right) {
        T tmpData = data[left];
        while (left < right) {
            if (left < right && ((Comparable)tmpData).compareTo(data[right]) <= 0) {
                right--;
            }
            data[left] = data[right];
            if (left < right && ((Comparable)tmpData).compareTo(data[left]) >= 0) {
                left++;
            }
            data[right] = data[left];
        }
        data[left] = tmpData;
        return left;
    }

}
