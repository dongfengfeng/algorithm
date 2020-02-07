package com.algorithm.base.tree.binarytree;

/**
 * @author dongfengfeng on 2020-02-07
 */
public class LinkedBinaryTree {

    private Struct root = new Struct();

    public Struct getNode() {
        return root;
    }

    public void add(Struct node, int value) {
        node.value = value;
        Struct left = new Struct();
        left.value = 2 * value;
        node.left = left;

        Struct right = new Struct();
        right.value = 2 * value + 1;
        node.right = right;
    }

    /**
     * 前序遍历
     * @param node
     */
    public void leftPrint(Struct node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value);
        leftPrint(node.left);
        leftPrint(node.right);
    }

    /**
     * 中序遍历
     * @param node
     */
    public void midPrint(Struct node) {
        if (node == null) {
            return;
        }
        midPrint(node.left);
        System.out.print(node.value);
        midPrint(node.right);
    }

    /**
     * 后序遍历
     * @param node
     */
    public void rightPrint(Struct node) {
        if (node == null) {
            return;
        }
        rightPrint(node.left);
        rightPrint(node.right);
        System.out.print(node.value);
    }

    class Struct {
        private Struct left;
        private int value;
        private Struct right;
        public Struct getLeft() {
            return left;
        }
        public Struct getRight() {
            return right;
        }
    }
}
