package com.algorithm.base.recursion.leetcode.reverseLinkedList;

/**
 * @author dff on 2020-03-21
 */
public class Solution {
    /**
     * 递归解法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        return recursion(head, head);
    }
    private ListNode recursion(ListNode head, ListNode point) {
        if (point == null || point.next == null) {
            return head;
        }
        ListNode next = point.next;
        point.next = next.next;
        next.next = head;
        return recursion(next, point);
    }
    /**
     * 非递归解法
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode oldHead = head;
        ListNode newHead = head;
        while (oldHead.next != null) {
            ListNode tmp = oldHead.next;
            oldHead.next = tmp.next;
            tmp.next = newHead;
            newHead = tmp;
        }
        return newHead;
    }

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }
}
