package com.algorithm.base.queue;

/**
 * @author dongfengfeng on 2020-01-29
 */
public interface MyQueue {
    /**
     * 入队
     * @param value
     * @return
     */
    boolean enqueue(int value);
    /**
     * 出队列
     * @return
     */
    int dequeue();

    /**
     * 队列元素数量
     * @return
     */
    int size();

    /**
     * 队列是否已满
     * @return
     */
    boolean isFull();

    /**
     * 清空队列
     */
    void clear();

}
