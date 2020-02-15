package com.algorithm.throught.greedy.case3;

/**
 * @author dongfengfeng on 2020-02-15
 */
public class Money {
    private int denomination;
    private int num;
    private int value;

    public Money(int denomination, int num) {
        this.denomination = denomination;
        this.num = num;
        this.value = denomination * num;
    }

    public int getDenomination() {
        return denomination;
    }

    public void setDenomination(int denomination) {
        this.denomination = denomination;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
