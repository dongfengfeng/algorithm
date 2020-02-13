package com.algorithm.base.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author dongfengfeng on 2020-02-12
 */
public class BluckSort {

    public void sort(Integer[] data) {
        List<List<Integer>> bluckDatas = bluck(data, 10);
        bluckSort(bluckDatas);
    }

    private void bluckSort(List<List<Integer>> bluckDatas) {
        for (List<Integer> list : bluckDatas) {
            Collections.sort(list);
        }
    }

    private List<List<Integer>> bluck(Integer[] data, int blucks) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = null;
        for (int i=0; i<blucks; i++) {
            list = new ArrayList<>();
            result.add(list);
        }

        for (int i=0; i<data.length; i++) {
           int index = i % blucks;
           result.get(index).add(data[i]);
        }
        return result;
    }
}
