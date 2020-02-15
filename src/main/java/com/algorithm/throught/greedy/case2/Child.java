package com.algorithm.throught.greedy.case2;

/**
 * @author dongfengfeng on 2020-02-15
 */
public class Child {
    private String name;
    private int expect;
    private Sweet sweet;

    public Child(String name, int expect) {
        this.name = name;
        this.expect = expect;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExpect() {
        return expect;
    }

    public void setExpect(int expect) {
        this.expect = expect;
    }

    public Sweet getSweet() {
        return sweet;
    }

    public void setSweet(Sweet sweet) {
        this.sweet = sweet;
    }
}
