package com.algorithm.base.array.leetcode15;

import com.algorithm.base.array.leetcode15.ThreeSum;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author dongfengfeng on 2020-01-29
 */
public class ThreeSumTest  {
    @Test
    public void test() {
        int[] array = new int[] {-1, 0, 1, 2, -1, -4, 4};

        List<List<Integer>> arrays = ThreeSum.INSTANCE.find(array);

        System.out.println(arrays);

        Assert.assertEquals(3, arrays.size());
    }

    @Test
    public void test2() {
        int[] array = new int[] {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};

        List<List<Integer>> arrays = ThreeSum.INSTANCE.find(array);

        System.out.println(arrays);

        Assert.assertEquals(6, arrays.size());
    }

    @Test
    public void test3() {
        int[] array = new int[] {0, 0, 0};

        List<List<Integer>> arrays = ThreeSum.INSTANCE.find(array);

        System.out.println(arrays);

        Assert.assertEquals(1, arrays.size());
    }
}
