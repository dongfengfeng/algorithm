package com.algorithm.advanced.bplustree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author dongfengfeng on 2020-02-26
 */
public class BPlusTree {

    private static final int NODE_SIZE = 4;

    private Node root;

    public BPlusTree() {
        this.root = new LeafNode();
    }

    public void insert(int key, String value) {
        this.root.insert(key, value);
    }

    public abstract class Node {
        List<Integer> keys = new ArrayList<>();

        public abstract void insert(int key, String value);

        public abstract boolean isOverflow();

        public abstract Node split();

        public abstract int getLeafFirstKey();
    }

    public class TreeNode extends Node {

        protected List<Node> children = new ArrayList<>();

        @Override
        public void insert(int key, String value) {
            Node child = getChild(key);
            child.insert(key, value);
            if (child.isOverflow()) {
                Node splitNode = child.split();
                insertChildNode(key, splitNode);
            }

            if (root.isOverflow()) {
                Node node = split();
                TreeNode newRoot = new TreeNode();
                newRoot.keys.add(node.getLeafFirstKey());
                newRoot.children.add(node);
                newRoot.children.add(this);
                root = newRoot;
            }
        }

        @Override
        public boolean isOverflow() {
            return children.size() > NODE_SIZE;
        }

        @Override
        public Node split() {
            int from = this.keys.size() / 2 + 1;
            int to = this.keys.size();

            List<Integer> subKeys = keys.subList(from, to);
            List<Node> subNodes = children.subList(from, to);

            TreeNode newNode = new TreeNode();
            newNode.keys.addAll(subKeys);
            newNode.children.addAll(subNodes);
            return newNode;
        }

        @Override
        public int getLeafFirstKey() {
            return 0;
        }

        private Node getChild(int key) {
            int index = Collections.binarySearch(keys, key);
            int keyIndex = index >=0 ? index + 1 : -index - 1;
            return children.get(keyIndex);
        }

        private void insertChildNode(int key, Node childNode) {
            int index = Collections.binarySearch(keys, key);
            int operIndex = index >=0 ? index + 1 : -index - 1;
            if (operIndex >= 0) {
                children.set(operIndex, childNode);
            } else {
                keys.add(childNode.getLeafFirstKey());
                children.add(childNode);
            }
        }
    }

    public class LeafNode extends Node {

        private List<String> values = new ArrayList<>(NODE_SIZE);

        @Override
        public void insert(int key, String value) {
            int index = Collections.binarySearch(keys, key);
            if (index >= 0) {
                values.set(index, value);
            } else {
                int arrIndex = -index - 1;
                keys.add(index);
                values.add(arrIndex, value);
            }

            if (root.isOverflow()) {
                Node split = split();

                TreeNode newNode = new TreeNode();
                newNode.keys.add(split.getLeafFirstKey());
                newNode.children.add(split);
                newNode.children.add(this);

                root = newNode;
            }
        }

        @Override
        public boolean isOverflow() {
            return keys.size() > NODE_SIZE;
        }

        @Override
        public Node split() {

            LeafNode spitNode = new LeafNode();

            int from = (keys.size() + 1) / 2;
            int to = keys.size();

            List<Integer> subKey = keys.subList(from, to);
            List<String> subValues = values.subList(from, to);

            spitNode.keys.addAll(subKey);
            spitNode.values.addAll(subValues);

            subKey.clear();
            subValues.clear();

            return spitNode;
        }

        @Override
        public int getLeafFirstKey() {
            return keys.get(0);
        }
    }
}
