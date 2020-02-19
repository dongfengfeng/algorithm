package com.thread.productorConsumer;

import java.util.Queue;
import java.util.Random;

/**
 * @author dongfengfeng on 2019-12-28
 */
public class Producer implements Runnable {

    private Queue<Integer> queue;
    private int maxSize;


    public Producer(Queue<Integer> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (queue) {
                if (queue.size() == maxSize) {
                    System.out.println("Queue is full");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Random random = new Random();
                    int i = random.nextInt(1000);
                    System.out.println(Thread.currentThread().getName() + " Produce:" + i);
                    queue.add(i);
                    queue.notify();
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
