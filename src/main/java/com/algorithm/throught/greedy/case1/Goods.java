package com.algorithm.throught.greedy.case1;

/**
 * @author dongfengfeng on 2020-02-15
 */
public class Goods {

    private String name;

    private int weight;

    private float value;

    private float price;

    public Goods(String name, int weight, float value, float price) {
        this.name = name;
        this.weight = weight;
        this.value = value;
        this.price = price;
    }

    public Goods(String name, int weight, float value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
        this.price = value / weight;
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

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
