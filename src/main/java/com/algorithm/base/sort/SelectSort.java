package com.algorithm.base.sort;

/**
 * @author dongfengfeng on 2020-02-12
 */
public class SelectSort<T> implements Sort<T> {
    @Override
    public void sort(T[] data) {
        if (!validate(data)) {
            return;
        }
        for (int i=0; i<data.length; i++) {
            T minData = data[i];
            int minIndex = i;
            for (int j=i+1; j<data.length; j++) {
                if (((Comparable)data[j]).compareTo(minData) < 0){
                    minData = data[j];
                    minIndex = j;
                }
            }

            if (i != minIndex) {
                T tmpData = data[minIndex];
                data[minIndex] = data[i];
                data[i] = tmpData;
            }
        }
    }
}
