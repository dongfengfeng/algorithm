package com.algorithm.base.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author dongfengfeng on 2020-01-29
 */
public class MyBlockingLinkedQueue implements MyQueue {

    private int capacity;

    private int size;

    private Node head = new Node(-1);

    private Node tail = head;

    private Lock lock = new ReentrantLock();

    private Condition eCondition = lock.newCondition();

    private Condition dCondition = lock.newCondition();

    public MyBlockingLinkedQueue(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean enqueue(int value) {
        try {
            lock.lock();
            if (size >= capacity) {
                eCondition.await();
                dCondition.signal();
            }
            Node newNode = new Node(value);
            tail.next = newNode;
            tail = newNode;
            size++;

            dCondition.signal();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return false;
    }

    @Override
    public int dequeue() {
        int result = -1;
        try {
            lock.lock();
            if (size == 0) {
                eCondition.signal();
                dCondition.await();
            }
            Node getNode = head.next;
            result = getNode.val;
            head.next = getNode.next;
            if (head.next == null) {
                tail = head;
            }
            size--;
            eCondition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public void clear() {
        head.next = null;
        tail = head;
        size = 0;
    }

    class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }
}
