package com.thread.printabc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dongfengfeng on 2020-01-18
 */
public class PrintABCUsingWaitNotify {
    private int times;

    private int state;

    private Object LOCK = new Object();

    public PrintABCUsingWaitNotify(int times) {
        this.times = times;
    }

    public static void main(String[] args) {
        PrintABCUsingWaitNotify print  = new PrintABCUsingWaitNotify(10);
        new Thread(print::printA, "thread-A").start();
        new Thread(print::printB, "thread-B").start();
        new Thread(print::printC, "thread-C").start();
    }

    public void printA() {
        print("A", 0);
    }
    public void printB() {
        print("B", 1);
    }
    public void printC() {
        print("C", 2);
    }

    public void print(String name, int curState) {
        for (int i=0; i<times; i++) {
            synchronized (LOCK) {
                while (state%3 != curState) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                state++;
                System.out.print(name);
                LOCK.notifyAll();
            }
        }
    }
}
