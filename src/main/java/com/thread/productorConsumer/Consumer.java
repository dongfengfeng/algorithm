package com.thread.productorConsumer;

import java.util.Queue;

/**
 * @author dongfengfeng on 2019-12-28
 */
public class Consumer implements Runnable {

    private Queue<Integer> queue;

    public Consumer(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                if (queue.isEmpty()) {
                    System.out.println("Queue is empty");
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    System.out.println(Thread.currentThread().getName() + " Consume:" + queue.peek());
                    queue.remove();
                    queue.notify();
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
