package com.algorithm.base.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dongfengfeng on 2020-02-07
 */
public class RecursionCacheStep {

    private int count;

    private Map<Integer, Integer> map = new HashMap<>();

    public int step(int n) {
        count++;
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int tmpSteps = step(n - 1) + step(n - 2);
        map.put(n, tmpSteps);
        return tmpSteps;
    }
}
