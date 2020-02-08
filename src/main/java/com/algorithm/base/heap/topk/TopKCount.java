package com.algorithm.base.heap.topk;

import java.util.PriorityQueue;

/**
 * @author dongfengfeng on 2020-02-08
 */
public class TopKCount {

    public int[] topK(int[] data, int k) {
        //小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i=0; i<data.length; i++) {
            if (data.length < k) {
                queue.offer(data[i]);
            } else {
                Integer value = queue.peek();
                if (data[i] > value) {
                    queue.poll();
                    queue.offer(data[i]);
                }
            }
        }
        int[] result = new int[k];
        int index = 0;
        while (!queue.isEmpty()) {
            result[index++] = queue.poll();
        }
        return result;
    }
}
