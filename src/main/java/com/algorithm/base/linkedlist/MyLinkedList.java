package com.algorithm.base.linkedlist;

/**
 * @author dongfengfeng on 2020-01-30
 */
public class MyLinkedList {

    private Node head = new Node(null);

    private int size;


    public void add(int value) {
        Node node = new Node(value);
        Node tmpHead = head;
        while (tmpHead.next != null) {
            tmpHead = tmpHead.next;
        }
        tmpHead.next = node;
    }

    public Node findByValue(int value) {
        Node node = head.next;
        while (node != null) {
            if (node.val == value) {
                return node;
            } else {
                node = node.next;
            }
        }
        return null;
    }

    public Node findByIndex(int index) {
        Node node = head.next;
        int curIndex = 0;
        while (node != null) {
            if (curIndex == index) {
                return node;
            } else {
                node = node.next;
                curIndex++;
            }
        }
        return null;
    }
    public void insertToHead(int value) {
        Node node = new Node(value);
        Node tmpNode = head.next;
        node.next = tmpNode;
        head.next = node;
    }

    public void insertToAfter(Node node, int value) {
        Node insertNode = new Node(value);
        Node after = node.next;
        insertNode.next = after;
        node.next = insertNode;
    }

    public void insertToBefore(Node node, int value) {
        Node insertNode = new Node(value);
        Node tmpHead = head.next;
        while (tmpHead != null && tmpHead.next != node) {
            tmpHead = tmpHead.next;
        }
        insertNode.next = node;
        tmpHead.next = insertNode;
    }

    public Integer removeFirst() {
        if (head.next != null) {
            Integer val = head.next.val;
            head.next = head.next.next;
            return val;
        }
        return null;
    }

    public Integer removeLast() {
        if (head.next == null) {
            return null;
        }
        if (head.next.next == null) {
            Integer val = head.next.val;
            head.next = null;
            return val;
        }
        Node tmpHead = head;
        while (tmpHead.next != null && tmpHead.next.next != null) {
            tmpHead = tmpHead.next;
        }
        Integer val = tmpHead.next.val;
        tmpHead.next = null;
        return val;
    }

    public void reverse() {
        Node current = head.next;
        Node curNext = null;
        Node newHead = current;
        while (current.next != null) {
            curNext = current.next;

            current.next = curNext.next;
            curNext.next = newHead;
            newHead = curNext;

        }
        head.next = newHead;
    }



    class Node {
        private Integer val;
        private Node next;

        public Node(Integer val) {
            this.val = val;
        }

        public Integer getVal() {
            return val;
        }
    }
}
