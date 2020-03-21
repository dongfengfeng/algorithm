package com.algorithm.base.tree.leetcode.nextRight2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dff on 2020-03-21
 */
public class Solution {

    /**
     * 非递归解法，从右往左推
     * @param root
     * @return
     */
    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            Node next = null;
            for (int i=0; i<len; i++) {
                Node cur = queue.poll();
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                cur.next = next;
                next = cur;
            }
        }
        return root;
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
