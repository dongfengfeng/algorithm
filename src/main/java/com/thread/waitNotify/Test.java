package com.thread.waitNotify;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dongfengfeng on 2019-12-28
 */
public class Test {
    public static int i = 1;
    public volatile static int j = 1;
    public volatile static boolean flag = false;
    public static int count = 0;

    public static Lock lock = new ReentrantLock();
    public static Condition conditionA = lock.newCondition();
    public static Condition conditionB = lock.newCondition();

    private static CountDownLatch latch = new CountDownLatch(2);
    private static AtomicInteger numA = new AtomicInteger();
    private static AtomicInteger numB = new AtomicInteger();

    private static byte[] block = new byte[0];

    public static void main(String[] args) {
        /*new Thread(() -> {
            while (i < 100) {
                synchronized (block) {
                    if (flag) {
                        try {
                            block.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + ":" + i++);
                        flag = true;
                        block.notify();
                    }
                }
            }
        }, "thread-1").start();
        new Thread(() -> {
            while (i < 100) {
                synchronized (block) {
                    if (!flag) {
                        try {
                            block.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + ":" + i++);
                        flag = false;
                        block.notify();
                    }
                }
            }
        }, "thread-2").start();*/

//        new Thread(() -> {
//            while (i < 100) {
//                lock.lock();
//                try {
//                    while (flag) {
//                        System.out.println(Thread.currentThread().getName() + ":" + i++);
//                        flag = false;
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                } finally {
//                    lock.unlock();
//                }
//            }
//        }, "thread-1").start();
//
//        new Thread(() -> {
//            while (i < 100) {
//                try {
//                    lock.lock();
//                    while (!flag) {
//                        System.out.println(Thread.currentThread().getName() + ":" + i++);
//                        flag = true;
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                } finally {
//                    lock.unlock();
//                }
//            }
//        }, "thread-2").start();
        new Thread(() -> {
            while (i < 100) {
                try {
                    lock.lock();
                    while (flag) {
                        conditionA.await();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + i++);
                    flag = true;
                    conditionB.signalAll();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        }, "thread-1").start();
        new Thread(() -> {
            while (i < 100) {
                try {
                    lock.lock();
                    while (!flag) {
                        conditionB.await();
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + i++);
                    flag = false;
                    conditionA.signalAll();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        }, "thread-2").start();
    }
}
