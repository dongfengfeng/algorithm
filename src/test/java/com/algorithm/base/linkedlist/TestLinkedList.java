package com.algorithm.base.linkedlist;

import org.junit.Test;

/**
 * @author dongfengfeng on 2020-01-30
 */
public class TestLinkedList {
    @Test
    public void testReverseSelf() {
        MyLinkedList list = new MyLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.add(70);

        list.reverse();
        System.out.print("dd");
    }
}
