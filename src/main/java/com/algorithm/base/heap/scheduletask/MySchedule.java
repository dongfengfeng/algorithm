package com.algorithm.base.heap.scheduletask;

import com.algorithm.base.heap.scheduletask.pojo.ScheduleBusi;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author dongfengfeng on 2020-02-11
 */
public class MySchedule implements Runnable {

    public static final MySchedule INSTANCE = new MySchedule();

    PriorityBlockingQueue<ScheduleBusi> queue = new PriorityBlockingQueue<>(8, (o1, o2) -> {
        if (o1.getRunTime() > o2.getRunTime()) {
            return 1;
        } else if (o1.getRunTime() < o2.getRunTime()){
            return -1;
        } else {
            return 0;
        }
    });

    public void delayRun(long runTime, Runnable runnable) {
        queue.offer(new ScheduleBusi(runTime, runnable));
    }

    @Override
    public void run() {
        while (true) {
            ScheduleBusi scheduleBusi = null;
            try {
                scheduleBusi = queue.poll(2, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (scheduleBusi == null) {
                continue;
            }

            long curTime = System.currentTimeMillis();
            long needTime = scheduleBusi.getRunTime() - curTime;
            if (needTime > 0) {
                try {
                    Thread.sleep(needTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            RunSchedule.INSTANCE.runTask(scheduleBusi);
        }
    }
}
