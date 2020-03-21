package com.algorithm.base.recursion.leetcode.searchTree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author dff on 2020-03-21
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return recursion(1, n);
    }

    private List<TreeNode> recursion(int start, int end) {
        List<TreeNode> allList = new LinkedList<>();
        if (start > end) {
            allList.add(null);
            return allList;
        }
        for (int i=start; i<=end; i++) {
            List<TreeNode> leftNodes = recursion(start, i - 1);
            List<TreeNode> rightNodes = recursion(i + 1, end);
            for (TreeNode l : leftNodes) {
                for (TreeNode r : rightNodes) {
                    TreeNode curNode = new TreeNode(i);
                    curNode.left = l;
                    curNode.right = r;
                    allList.add(curNode);
                }
            }
        }
        return allList;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
