package com.algorithm.base.sort;

/**
 * @author dongfengfeng on 2020-02-12
 */
public class InsertSort<T> implements Sort<T> {
    @Override
    public void sort(T[] data) {
        if (!validate(data)) {
            return;
        }

        for (int i=0; i<data.length; i++) {
            T insertData = data[i+1];
            int index = i;
            while (index >=0 && ((Comparable)data[index]).compareTo(insertData) > 0) {
                data[index+1] = data[index];
                index--;
            }
            data[index+1] = insertData;
        }
    }
}
