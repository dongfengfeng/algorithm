package com.algorithm.throught.backtracing.zeroonepackage;

/**
 * @author dongfengfeng on 2020-02-16
 */
public class Package {
    private String name;
    private int weight;
    private int value;

    public Package(String name, int weight, int value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
