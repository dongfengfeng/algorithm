package com.thread.printabc;

import java.util.concurrent.Semaphore;

/**
 * @author dongfengfeng on 2020-01-18
 */
public class PrintABCUsingSemaphore {
    private int times;
    private Semaphore semaphoreA = new Semaphore(1);
    private Semaphore semaphoreB = new Semaphore(0);
    private Semaphore semaphoreC = new Semaphore(0);

    public PrintABCUsingSemaphore(int times) {
        this.times = times;
    }

    public static void main(String[] args) {
        PrintABCUsingSemaphore print  = new PrintABCUsingSemaphore(10);
        new Thread(print::printB, "thread-B").start();
        new Thread(print::printC, "thread-C").start();
        new Thread(print::printA, "thread-A").start();
    }

    public void printA() {
        print("A", semaphoreA, semaphoreB);
    }
    public void printB() {
        print("B", semaphoreB, semaphoreC);
    }
    public void printC() {
        print("C", semaphoreC, semaphoreA);
    }

    public void print(String name, Semaphore current, Semaphore next) {
        for (int i=0; i<times; i++) {
            try {
                current.acquire();
                System.out.print(name);
                next.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
