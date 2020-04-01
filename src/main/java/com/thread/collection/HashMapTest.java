package com.thread.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dff on 2020-04-01
 */
public class HashMapTest {
    /**
     * jdk1.7中会出现死循环
     * @param args
     */
    public static void main(String[] args) {
        Thread hashThread0 = new HashMapThread();
        Thread hashThread1 = new HashMapThread();
        Thread hashThread2 = new HashMapThread();
        Thread hashThread3 = new HashMapThread();
        Thread hashThread4 = new HashMapThread();

        hashThread0.start();
        hashThread1.start();
        hashThread2.start();
        hashThread3.start();
        hashThread4.start();
    }
}
class HashMapThread extends Thread {
    private static AtomicInteger ai = new AtomicInteger();
    private static Map<Integer, Integer> map = new HashMap<>();
    @Override
    public void run() {
        map.put(ai.get(), ai.get());
        ai.incrementAndGet();
    }
}
