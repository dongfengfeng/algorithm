package com.algorithm.base.tree.leetcode.buildTree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dff on 2020-03-21
 */
public class Solution {
    Map<Integer, Integer> postMap = new HashMap<>();
    Map<Integer, Integer> preMap = new HashMap<>();
    /**
     * 通过中序遍历和后序遍历数组重构二叉树
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        for (int i=0; i<inorder.length; i++) {
            postMap.put(inorder[i], i);
        }
        TreeNode root = build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        return root;
    }
    private TreeNode build(int[] inorder, int i0, int i1, int[] postorder, int p0, int p1) {
        if (i0 > i1 || p0 > p1) {
            return null;
        }
        //根结点位于后续遍历最后一个元素
        Integer mid = postMap.get(postorder[p1]);
        //左子树节点个数
        int count = mid - i0;
        TreeNode root = new TreeNode(inorder[mid]);
        TreeNode left = build(inorder, i0, mid - 1, postorder, p0, p0 + count - 1);
        TreeNode right = build(inorder, mid + 1, i1, postorder, p0 + count, p1 - 1);
        root.left = left;
        root.right = right;
        return root;
    }

    /**
     * 通过中序遍历和前序遍历数组重构二叉树
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (inorder == null || inorder.length == 0) {
            return null;
        }
        for (int i=0; i<inorder.length; i++) {
            preMap.put(inorder[i], i);
        }
        TreeNode root = build2(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;
    }

    private TreeNode build2(int[] preorder, int p0, int p1, int[] inorder, int i0, int i1) {
        if (p0 > p1 || i0 > i1) {
            return null;
        }
        //前序遍历数组第一个节点为根结点
        Integer mid = preMap.get(preorder[p0]);
        //左子树节点个数
        int count = mid - i0;
        TreeNode root = new TreeNode(inorder[mid]);
        TreeNode left = build2(preorder, p0 + 1, p0 + count, inorder, i0, mid - 1);
        TreeNode right = build2(preorder, p0 + count + 1, p1, inorder, mid + 1, i1);
        root.left = left;
        root.right = right;
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
