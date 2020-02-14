package com.algorithm.base.sort;

/**
 * @author dongfengfeng on 2020-02-14
 */
public class SleepSort {
    public void sort(int[] data) {
        SleepThread[] sleepThreads = new SleepThread[data.length];
        for (int i=0; i<data.length; i++) {
            sleepThreads[i] = new SleepThread(data[i]);
        }
        for (int i=0; i<data.length; i++) {
            sleepThreads[i].start();
        }
    }

    class SleepThread extends Thread {

        private int s;

        public SleepThread(int s) {
            this.s = s;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(s * 10 * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(s);
        }
    }
}
