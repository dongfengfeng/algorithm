package com.algorithm.base.charsmatch.bf;

import org.junit.Test;

/**
 * @author dongfengfeng on 2020-01-26
 */
public class BruteForceTest {

    @Test
    public void testBructForce() {
        BruteForce instance = new BruteForce();

        String src = "my name is dff";
        String find = "dff";

        int findIndex = instance.find(src, find);
        System.out.println("查找的位置索引为:" + findIndex);

        String sub = src.substring(findIndex);
        System.out.println("截取后的字符串为:" + sub);
    }

    @Test
    public void testBructForceNot() {
        BruteForce instance = new BruteForce();

        String src = "my name is dff";
        String find = "dff2";

        int findIndex = instance.find(src, find);
        System.out.println("查找的位置索引为:" + findIndex);
    }
}
