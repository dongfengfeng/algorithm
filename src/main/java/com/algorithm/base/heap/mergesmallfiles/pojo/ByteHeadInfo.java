package com.algorithm.base.heap.mergesmallfiles.pojo;

/**
 * @author dongfengfeng on 2020-02-10
 */
public class ByteHeadInfo {
    private byte value;

    private int index;

    public ByteHeadInfo(byte value, int index) {
        this.value = value;
        this.index = index;
    }

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
