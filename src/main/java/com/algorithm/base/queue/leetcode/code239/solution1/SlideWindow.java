package com.algorithm.base.queue.leetcode.code239.solution1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dongfengfeng on 2020-01-29
 */
public class SlideWindow {

    public int[] max(int[] arrays, int k) {
        if (arrays == null) {
            return null;
        }
        if (arrays.length == 0 || arrays.length < k) {
            return arrays;
        }
        int[] result = new int[arrays.length - k + 1];
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<k; i++) {
            queue.offer(arrays[i]);
        }
        int index = 0;
        for (int i=k; i<arrays.length; i++) {
            int max = max(queue);
            result[index++] = max;
            queue.poll();
            queue.offer(arrays[i]);
        }
        return result;
    }

    private int max(Queue<Integer> queue) {
        int max = queue.peek();
        for (Integer ele : queue) {
            if (ele > max) {
                max = ele;
            }
        }
        return max;
    }
}
