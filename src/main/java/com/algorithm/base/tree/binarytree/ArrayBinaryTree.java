package com.algorithm.base.tree.binarytree;

/**
 * @author dongfengfeng on 2020-02-07
 */
public class ArrayBinaryTree {
    private int[] array = new int[64];

    public void putRoot() {
        for (int i=0; i<16; i++) {
            array[i] = i;
        }
    }

    /**
     * 前序遍历
     * @param index
     */
    public void leftPrint(int index) {
        if (array[index] == 0) {
            return;
        }
        System.out.print(array[index]);
        leftPrint(2 * index);
        leftPrint(2 * index + 1);
    }

    /**
     * 中序遍历
     * @param index
     */
    public void midPrint(int index) {
        if (array[index] == 0) {
            return;
        }
        midPrint(2 * index);
        System.out.print(array[index]);
        midPrint(2 * index + 1);
    }

    /**
     * 后续遍历
     * @param index
     */
    public void rightPrint(int index) {
        if (array[index] == 0) {
            return;
        }
        rightPrint(2 * index);
        rightPrint(2 * index + 1);
        System.out.print(array[index]);
    }
}
