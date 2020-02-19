package com.thread.threadLocal;

import java.util.concurrent.CyclicBarrier;

/**
 * @author dongfengfeng on 2019-12-26
 */
public class ThreadLocalUtil {
    private static final ThreadLocal<Integer> testThreadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(4);
        for (int i = 0; i < 4; i ++) {
            new Thread(new TestThread(barrier)).start();
        }
    }

    static class TestThread implements Runnable{
        private CyclicBarrier barrier;

        public TestThread(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                barrier.await();
                for (int i = 0; i < 100; i++) {
                    Integer value = testThreadLocal.get();
                    if (value == null) {
                        value = 0;
                    }
                    Integer sum = value + i;
                    testThreadLocal.set(sum);
                }
                System.out.println(Thread.currentThread().getName() + " sum is " + testThreadLocal.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

