package com.algorithm.base.heap.midnum;

import java.util.PriorityQueue;

/**
 * @author dongfengfeng on 2020-02-08
 */
public class MidnumCount {
    //大顶堆
    private PriorityQueue<Integer> bigHeap = new PriorityQueue<>(51, (o1, o2) -> {
        if (o1 < o2) {
            return 1;
        } else if (o1 > o2) {
            return -1;
        } else {
            return 0;
        }
    });
    //小顶堆
    private PriorityQueue<Integer> littleHeap = new PriorityQueue<>(51);

    private int count;

    public void putVal(int value) {
        count++;
        if (bigHeap.isEmpty() && littleHeap.isEmpty()) {
            bigHeap.offer(value);
            return;
        }

        if (bigHeap.peek() < value) {
            littleHeap.offer(value);
        } else {
            bigHeap.offer(value);
        }
        int tmpCount = count / 2;
        if (bigHeap.size() > tmpCount) {
            move(bigHeap, littleHeap, bigHeap.size() - tmpCount);
            return;
        }
        if (littleHeap.size() > tmpCount) {
            move(littleHeap, bigHeap, littleHeap.size() - tmpCount);
            return;
        }
    }

    public int getMidnum() {
        return bigHeap.peek();
    }
    private void move(PriorityQueue<Integer> src, PriorityQueue<Integer> target, int num) {
        for (int i=0; i<num; i++) {
            target.offer(src.poll());
        }
    }
}
