package com.algorithm.base.sort;

/**
 * @author dongfengfeng on 2020-02-12
 */
public interface Sort<T> {

    void sort(T[] data);

    default boolean validate(T[] data) {
        if (data == null || data.length == 0) {
            return false;
        }
        if (!(data[0] instanceof Comparable)) {
            return false;
        }
        return true;
    }
}
