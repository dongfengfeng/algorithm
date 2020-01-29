package com.algorithm.base.array.leetcode169;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author dongfengfeng on 2020-01-29
 */
public class MajorityTest {
    @Test
    public void testMajority() {
        int[] value = new int[] {3, 2, 3};

        Majority test = new Majority();
        int outvalue = test.find(value);
        Assert.assertEquals(outvalue, 3);
    }

    @Test
    public void testMajorityMore() {
        int[] data = new int[] {2, 2, 1, 1, 1, 2, 2};
        Majority majorityInstance = new Majority();
        int majorityOut = majorityInstance.find(data);
        Assert.assertEquals(majorityOut, 2);
    }


    @Test
    public void testMajorityMoreValue() {
        int[] data = new int[] {3,2,3,2,3,2,2};
        Majority majorityInstance = new Majority();
        int majorityOut = majorityInstance.find(data);
        Assert.assertEquals(majorityOut, 2);
    }
}
