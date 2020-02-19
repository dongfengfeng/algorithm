package com.thread.printabc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dongfengfeng on 2020-01-18
 */
public class PrintABCUsingLock {

    private int times;

    private int state;

    private Lock lock = new ReentrantLock();

    public PrintABCUsingLock(int times) {
        this.times = times;
    }

    public static void main(String[] args) {
        PrintABCUsingLock print  = new PrintABCUsingLock(10);
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
        for (int i=0; i<times;) {
            lock.lock();
            if (state%3 == curState) {
                System.out.print(name);
                state++;
                i++;
            }
            lock.unlock();
        }
    }
}
