package com.thread.printabc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author dongfengfeng on 2020-02-19
 */
public class PrintABCUsingThreadPool {

    private static int times = 10;

    private static ExecutorService service = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        PrintABCUsingThreadPool print  = new PrintABCUsingThreadPool();
        Thread thread1 = new Thread(print::printA, "thread-A");
        Thread thread2 = new Thread(print::printB, "thread-B");
        Thread thread3 = new Thread(print::printC, "thread-C");
        for (int i=0; i<times; i++) {
            service.execute(thread1);
            service.execute(thread2);
            service.execute(thread3);
        }
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
        System.out.print(name);
    }
}
