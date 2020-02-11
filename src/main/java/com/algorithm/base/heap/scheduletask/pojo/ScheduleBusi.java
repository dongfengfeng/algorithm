package com.algorithm.base.heap.scheduletask.pojo;

/**
 * @author dongfengfeng on 2020-02-11
 */
public class ScheduleBusi {
    private long runTime;
    private Runnable runnable;

    public ScheduleBusi(long runTime, Runnable runnable) {
        this.runTime = runTime;
        this.runnable = runnable;
    }

    public long getRunTime() {
        return runTime;
    }

    public void setRunTime(long runTime) {
        this.runTime = runTime;
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public void setRunnable(Runnable runnable) {
        this.runnable = runnable;
    }
}
