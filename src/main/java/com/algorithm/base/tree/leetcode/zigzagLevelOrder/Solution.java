package com.algorithm.base.tree.leetcode.zigzagLevelOrder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author dff on 2020-03-24
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> tmpQueue = new LinkedList<>();

        boolean startLeft = false;
        List<Integer> subList = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            subList.add(node.val);
            if (startLeft) {
                if (node.left != null) {
                    tmpQueue.offer(node.left);
                }
                if (node.right != null) {
                    tmpQueue.offer(node.right);
                }
            } else {
                if (node.right != null) {
                    tmpQueue.offer(node.right);
                }
                if (node.left != null) {
                    tmpQueue.offer(node.left);
                }
            }
            if (queue.isEmpty()) {
                resultList.add(new ArrayList<>(subList));
                subList.clear();
                while (!tmpQueue.isEmpty()) {
                    queue.offer(tmpQueue.poll());
                }
                startLeft = !startLeft;
            }
        }
        return resultList;
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
