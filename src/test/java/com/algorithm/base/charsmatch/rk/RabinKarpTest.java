package com.algorithm.base.charsmatch.rk;

import org.junit.Test;

/**
 * @author dongfengfeng on 2020-01-28
 */
public class RabinKarpTest {
    @Test
    public void testRk() {
        RabinKarp rk = new RabinKarp();

        String src = "aa bb ad cc dd dc";
        String find = "c dd";

        int findIndex = rk.find(src, find);
        System.out.println("查找的位置索引为:" + findIndex);

        if (findIndex != -1) {
            String sub = src.substring(findIndex, findIndex + find.length());
            System.out.println("截取后的字符串为:" + sub);
        }
    }
}
