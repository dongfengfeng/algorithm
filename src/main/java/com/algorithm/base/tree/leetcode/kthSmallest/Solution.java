package com.algorithm.base.tree.leetcode.kthSmallest;

import com.algorithm.base.stack.leetcode.code232.MyQueue;

import java.util.Stack;

/**
 * @author dff on 2020-03-24
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int[] tops = new int[k];
        int index = 0;
        while (index < k) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (stack.empty()) {
                    break;
                }
                root = stack.pop();
                tops[index++] = root.val;
                root = root.right;
            }
        }
        return tops[k-1];
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
