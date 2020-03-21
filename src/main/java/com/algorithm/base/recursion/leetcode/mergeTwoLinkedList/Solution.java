package com.algorithm.base.recursion.leetcode.mergeTwoLinkedList;

/**
 * @author dff on 2020-03-21
 */
public class Solution {
    /**
     * 递归解法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head = null;
        if (l1.val <= l2.val) {
            head = l1;
            head.next = mergeTwoLists(l1.next, l2);
        }
        if (l1.val > l2.val) {
            head = l2;
            head.next = mergeTwoLists(l1, l2.next);
        }
        return head;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            }
            if (l1.val > l2.val) {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        //剩余链表
        pre.next = l1 == null ? l2 : l1;

        return head.next;
    }



    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
