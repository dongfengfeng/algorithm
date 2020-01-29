package com.algorithm.base.array.leetcode41;

import com.algorithm.base.array.leetcode41.MinMissingNumber;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author dongfengfeng on 2020-01-29
 */
public class MinMissingNumberTest {
    @Test
    public void testfind() {
        int[] array = new int[] {1, 2, 0};

        MinMissingNumber instance = new MinMissingNumber();
        int result = instance.find(array);
        Assert.assertEquals(3, result);
    }

    @Test
    public void testfind2() {
        int[] array = new int[] {3, 4, -1, 1};

        MinMissingNumber instance = new MinMissingNumber();
        int result = instance.find(array);
        Assert.assertEquals(2, result);
    }

    @Test
    public void testfind3() {
        int[] array = new int[] {7, 8, 9, 11, 12};

        MinMissingNumber instance = new MinMissingNumber();
        int result = instance.find(array);
        Assert.assertEquals(1, result);
    }

    @Test
    public void testfindNull() {
        int[] array = new int[] {};

        MinMissingNumber instance = new MinMissingNumber();
        int result = instance.find(array);
        Assert.assertEquals(1, result);
    }

    @Test
    public void testfindBig() {
        int[] array = new int[] {999, 500, 1};

        MinMissingNumber instance = new MinMissingNumber();
        int result = instance.find(array);
        Assert.assertEquals(2, result);
    }

    @Test
    public void testfindBigNum() {
        int[] array = new int[] {2147483647};

        MinMissingNumber instance = new MinMissingNumber();
        int result = instance.find(array);
        Assert.assertEquals(1, result);
    }
}
