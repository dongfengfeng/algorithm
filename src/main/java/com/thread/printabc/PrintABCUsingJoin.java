package com.thread.printabc;

/**
 * @author dongfengfeng on 2020-02-19
 */
public class PrintABCUsingJoin {

    public static void main(String[] args) {
        PrintABCUsingJoin print  = new PrintABCUsingJoin();
        Thread thread1 = new Thread(print::printA, "thread-A");
        Thread thread2 = new Thread(print::printB, "thread-B");
        Thread thread3 = new Thread(print::printC, "thread-C");

        try {
            thread1.start();
            thread2.start();
            thread3.start();

            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printA() {
        print("A");
    }
    public void printB() {
        print("B");
    }
    public void printC() {
        print("C");
    }

    public void print(String name) {
        System.out.print(name);
    }
}
