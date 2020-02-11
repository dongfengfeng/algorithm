package com.algorithm.base.heap.scheduletask;

import com.algorithm.base.heap.scheduletask.pojo.ScheduleBusi;

/**
 * @author dongfengfeng on 2020-02-11
 */
public class RunSchedule {

    public static final RunSchedule INSTANCE = new RunSchedule();

    public void runTask(ScheduleBusi scheduleBusi) {
        long curTime;
        while(true) {
            curTime = System.currentTimeMillis();
            long needTime = scheduleBusi.getRunTime() - curTime;
            if (needTime > 0) {
                try {
                    Thread.sleep(needTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                break;
            }
        }
        scheduleBusi.getRunnable().run();
    }
}
