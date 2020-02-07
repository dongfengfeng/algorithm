package com.algorithm.base.tree.binarysearchtree;

/**
 * @author dongfengfeng on 2020-02-07
 */
public class BinarySearchTree {

    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode();
            root.value = value;
            return;
        }
        TreeNode findIns = root;

        while (findIns != null) {
            if (value < findIns.value) {
                if (findIns.left == null) {
                    TreeNode node = new TreeNode();
                    node.value = value;
                    findIns.left = node;
                    return;
                }
                findIns = findIns.left;
            } else if (value > findIns.value) {
                if (findIns.right == null) {
                    TreeNode node = new TreeNode();
                    node.value = value;
                    findIns.right = node;
                    return;
                }
                findIns = findIns.right;
            }
        }
    }

    public TreeNode search(int value) {
        TreeNode findNode = root;
        while (findNode != null) {
            if (findNode.value > value) {
                findNode = findNode.left;
            } else if (findNode.value < value) {
                findNode = findNode.right;
            } else {
                return findNode;
            }
        }
        return null;
    }
    
    public void delete(int value) {
        TreeNode findNode = root;
        TreeNode findNodeParent = root;

        while (findNode != null) {
            if (findNode.value > value) {
                findNodeParent = findNode;
                findNode = findNode.left;
            } else if (findNode.value < value) {
                findNodeParent = findNode;
                findNode = findNode.right;
            } else {
                break;
            }
        }

        if (findNode == null) {
            return;
        }

        if (findNode.left != null && findNode.right != null) {
            TreeNode rightMinNode = findNode.right;
            TreeNode rightMinNodeParent = findNode.right;

            while (rightMinNode != null) {
                if (rightMinNode.left != null) {
                    rightMinNodeParent = rightMinNode;
                    rightMinNode = rightMinNode.left;
                    continue;
                }
                break;
            }
            setChildTreeNodeValue(findNodeParent, findNode, rightMinNode);
            setChildTreeNode(rightMinNodeParent, rightMinNode, null);
        } else if (findNode.left != null || findNode.right != null) {
            if (findNode.left == null) {
                setChildTreeNode(findNodeParent, findNode, findNode.right);
            } else {
                setChildTreeNode(findNodeParent, findNode, findNode.left);
            }
        } else {
            setChildTreeNode(findNodeParent, findNode, null);
        }
    }

    private void setChildTreeNode(TreeNode findNodeParent, TreeNode src, TreeNode target) {
        if (findNodeParent.left == src) {
            findNodeParent.left = target;
        } else if (findNodeParent.right == src) {
            findNodeParent.right = target;
        }
    }
    private void setChildTreeNodeValue(TreeNode findNodeParent, TreeNode src, TreeNode target) {
        if (findNodeParent.left == src) {
            findNodeParent.left.value = target.value;
        } else if (findNodeParent.right == src) {
            findNodeParent.right.value = target.value;
        }
    }

    class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;
    }
}
