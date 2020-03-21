package com.algorithm.base.tree.leetcode.serializeTree;

/**
 * @author dff on 2020-03-21
 */
public class Solution {

    private int index;

    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        return doSerialize(root, sb);
    }
    private String doSerialize(TreeNode root, StringBuffer sb) {
        if (root == null) {
            sb.append("#/");
        } else {
            sb.append(root.val).append("/");
            doSerialize(root.left, sb);
            doSerialize(root.right, sb);
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        String[] split = data.split("/");
        TreeNode root = doDeserialize(split);
        index = -1;
        return root;
    }

    private TreeNode doDeserialize(String[] split) {
        if (split[++index].equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(split[index]));
        root.left = doDeserialize(split);
        root.right = doDeserialize(split);
        return root;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
