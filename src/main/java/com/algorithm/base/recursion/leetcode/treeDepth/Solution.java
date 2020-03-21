package com.algorithm.base.recursion.leetcode.treeDepth;

/**
 * @author dff on 2020-03-21
 */
public class Solution {

    public int maxDepth(TreeNode root) {
        return recursion(root, 0);
    }
    private int recursion(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        return Math.max(recursion(root.left, depth + 1), recursion(root.right, depth + 1));
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
