package com.algorithm.base.queue;

/**
 * @author dongfengfeng on 2020-01-29
 */
public class MyArrayQueue implements MyQueue {

    private int[] datas;

    private int capacity;

    private int size;

    private int head;

    private int tail;

    public MyArrayQueue(int capacity) {
        this.capacity = capacity;
        datas = new int[capacity];
        size = 0;
        head = 0;
        tail = 0;
    }

    @Override
    public boolean enqueue(int value) {
        if (tail < capacity) {
            if (head == tail) {
                head = 0;
                tail = 0;
            }
            //在此优化处理，对数据进行搬移
            if (tail == capacity) {
               for (int i=head; i<tail; i++) {
                   datas[i - head] = datas[i];
               }
                tail = tail - head;
                head = 0;
            }

            if (tail < capacity) {
                datas[tail] = value;
                tail++;
                size++;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int dequeue() {
        int result = -1;
        if (head < tail) {
            size--;
            result = datas[head++];
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public void clear() {
        for (int i=0; i<capacity; i++) {
            datas[i] = 0;
        }
        head = 0;
        tail = 0;
        size = 0;
    }
}
