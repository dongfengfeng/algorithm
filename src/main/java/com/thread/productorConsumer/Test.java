package com.thread.productorConsumer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dongfengfeng on 2019-12-28
 */
public class Test {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        int maxSize = 10;
        for (int i=0; i<2; i++) {
            new Thread(new Producer(queue, maxSize), "p_thread-" + i).start();
            new Thread(new Consumer(queue), "c_thread-" + i).start();
        }
    }
}
