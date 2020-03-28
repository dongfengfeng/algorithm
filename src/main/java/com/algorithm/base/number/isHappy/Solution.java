package com.algorithm.base.number.isHappy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dff on 2020-03-28
 */
public class Solution {
    Set<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {
        if (set.contains(n)) {
            return false;
        } else {
            set.add(n);
        }
        int sum = 0;
        while (n > 0) {
            sum += Math.pow((n % 10), 2);
            n = n / 10;
        }
        if (sum == 1) {
            return true;
        }
        return isHappy(sum);
    }
}
