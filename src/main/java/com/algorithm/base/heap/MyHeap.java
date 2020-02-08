package com.algorithm.base.heap;

/**
 * @author dongfengfeng on 2020-02-08
 */
public class MyHeap {
    private final int[] data;
    private final int capacity;
    private int length;

    public MyHeap(int capacity) {
        this.data = new int[capacity];
        this.capacity = capacity;
    }

    public void setData(int[] setData) {
        for (int i=0; i<setData.length; i++) {
            length++;
            if (length <= capacity) {
                data[length] = setData[i];
            }
        }
    }

    /**
     * 插入元素
     * @param value
     */
    public void insert(int value) {
        if (length >= capacity) {
            return;
        }
        length++;
        data[length] = value;

        int insertIndex = length;
        int tmpVal;

        while (insertIndex / 2 > 0 && data[insertIndex] > data[insertIndex / 2]) {
            tmpVal = data[insertIndex];
            data[insertIndex] = data[insertIndex / 2];
            data[insertIndex / 2] = tmpVal;

            insertIndex = insertIndex / 2;
        }
    }

    public void print() {
        for (int i=0; i<data.length; i++) {
            System.out.print(data[i] + "\t");
        }
        System.out.println();
    }

    /**
     * 删除堆顶元素
     */
    public void deleteMax() {
        if (length <= 0) {
            return;
        }
        data[1] = data[length];
        heap(data, 1);
    }

    /**
     * 堆化
     * @param data
     * @param start
     */
    private void heap(int[] data, int start) {
        int tmpIndex;
        while (true) {
            tmpIndex = start;
            if (tmpIndex * 2 <= length && data[tmpIndex * 2] > data[tmpIndex]) {
                tmpIndex = tmpIndex * 2;
            }
            if (tmpIndex * 2 <= length && data[tmpIndex * 2 + 1] > data[tmpIndex]) {
                tmpIndex = tmpIndex * 2 + 1;
            }
            if (tmpIndex == start) {
                break;
            }

            int tmpVal = data[start];
            data[start] = data[tmpIndex];
            data[tmpIndex] = tmpIndex;

            start = tmpIndex;
        }
    }
}
