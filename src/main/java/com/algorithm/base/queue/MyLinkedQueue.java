package com.algorithm.base.queue;

/**
 * @author dongfengfeng on 2020-01-29
 */
public class MyLinkedQueue implements MyQueue {

    private int capacity;

    private int size;

    private Node head = new Node(-1);

    private Node tail = head;

    public MyLinkedQueue(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean enqueue(int value) {
        if (size < capacity) {
            Node newNode = new Node(value);
            tail.next = newNode;
            tail = newNode;
            size++;
            return true;
        }
        return false;
    }

    @Override
    public int dequeue() {
        int result = -1;
        if (head != tail) {
            Node getNode = head.next;
            result = getNode.val;
            head.next = getNode.next;
            if (head.next == null) {
                tail = head;
            }
            size--;
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
