package com.algorithm.base.recursion.leetcode.changeNodes;

/**
 * @author dff on 2020-03-20
 */
public class Solution {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Solution solution = new Solution();
        solution.swapPairs(node1);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head;
        ListNode next = head.next;
        head = next;
        head.next = swapPairs(next.next);
        next.next = newHead;
        return head;
    }

    /** 单链表的节点信息 */
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
