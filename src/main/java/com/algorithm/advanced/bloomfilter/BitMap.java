package com.algorithm.advanced.bloomfilter;

/**
 * @author dongfengfeng on 2020-02-23
 */
public class BitMap {
    private int bits;

    private char[] datas;

    public BitMap(int bits) {
        this.bits = bits;
        datas = new char[bits/16 + 1];
    }

    public void set(int k) {
        if (k > bits) {
            return;
        }
        int byteindex = k / 16;
        int bitindex = k % 16;
        datas[byteindex] |= (1 << bitindex);
    }

    public boolean get(int k) {
        if (k > bits) {
            return false;
        }
        int byteindex = k / 16;
        int bitindex = k % 16;
        return (datas[byteindex] & (1 << bitindex)) == 1;
    }
}
