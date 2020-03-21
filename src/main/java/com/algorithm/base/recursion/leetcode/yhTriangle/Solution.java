package com.algorithm.base.recursion.leetcode.yhTriangle;

import java.util.*;

/**
 * @author dff on 2020-03-21
 */
public class Solution {
    /**
     * 递归解法
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> returnList = new ArrayList<>();
        List<Integer> subList;
        Map<String, Integer> mem = new HashMap<>();
        for (int i=0; i<numRows; i++) {
            subList = new ArrayList<>();
            for (int j=0; j<=i; j++) {
                int num = recursion(i, j, mem);
                subList.add(num);
            }
            returnList.add(subList);
        }
        return returnList;
    }

    private int recursion(int row, int col, Map<String, Integer> mem) {
        if (col == 0 || col == row) {
            return 1;
        }
        int result;
        if (mem.containsKey(row + ":" + col)) {
            return mem.get(row + ":" + col);
        } else {
            result = recursion(row - 1, col - 1, mem) + recursion(row - 1, col, mem);
            mem.put(row + ":" + col, result);
        }
        return result;
    }

    /**
     * 非递归解法
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> preList = new ArrayList<>();
        if (numRows == 0) {
            return list;
        }
        List<Integer> subList;
        for (int i=0; i<numRows; i++) {
            subList = new ArrayList<>(i);
            for (int j=0; j<=i; j++) {
                if (j == 0 || j == i) {
                    subList.add(1);
                } else {
                    int curNum = preList.get(j-1) + preList.get(j);
                    subList.add(curNum);
                }
            }
            preList = subList;
            list.add(subList);
        }
        return list;
    }

    /**
     * 返回杨辉三角第n行
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        if (rowIndex == 0) {
            list.add(1);
            return list;
        }
        List<Integer> preList = new ArrayList<>();
        for (int i=1; i<=rowIndex+1; i++) {
            while (list.size() < i) {
                if (list.size() == 0 || list.size() == i - 1) {
                    list.add(1);
                } else {
                    list.add(preList.get(list.size() - 1) + preList.get(list.size()));
                }
            }
            preList = new ArrayList<>(list);
            list.clear();
        }
        return preList;
    }
}
