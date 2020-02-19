package com.thread.printabc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dongfengfeng on 2020-01-18
 */
public class PrintABCUsingLockCondition {
    private int times;

    private int state;

    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();

    public PrintABCUsingLockCondition(int times) {
        this.times = times;
    }

    public static void main(String[] args) {
        PrintABCUsingLockCondition print  = new PrintABCUsingLockCondition(10);
        new Thread(print::printA, "thread-A").start();
        new Thread(print::printB, "thread-B").start();
        new Thread(print::printC, "thread-C").start();
    }

    public void printA() {
        print("A", 0, conditionA, conditionB);
    }
    public void printB() {
        print("B", 1, conditionB, conditionC);
    }
    public void printC() {
        print("C", 2, conditionC, conditionA);
    }

    public void print(String name, int targetState, Condition curContion, Condition nextCondition) {
        for (int i=0; i<times;) {
            lock.lock();
            try {
                while (state%3 != targetState) {
                    curContion.await();
                }
                System.out.print(name);
                state++;
                i++;
                nextCondition.signal();
            } catch (InterruptedException e){
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
