package com.algorithm.base.sort;

/**
 * 冒泡排序
 * @author dongfengfeng on 2020-02-12
 */
public class BubbleSort<T> implements Sort<T> {

    @Override
    public void sort(T[] data) {
        if (!validate(data)) {
            return;
        }
        boolean breakFlag = false;
        for (int i=0; i<data.length; i++) {
            for (int j=0; j<data.length-1-i; j++) {
                if (((Comparable)data[j]).compareTo(data[j+1]) > 0) {
                    T tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                    breakFlag = true;
                }
            }
            if (!breakFlag) {
                break;
            }
        }
    }
}
