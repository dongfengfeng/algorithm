package com.algorithm.base.heap.bigfiletopn.pojo;

/**
 * @author dongfengfeng on 2020-02-11
 */
public class KeyBusi {
    private String key;

    private int count;

    public KeyBusi(String key, int count) {
        this.key = key;
        this.count = count;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
