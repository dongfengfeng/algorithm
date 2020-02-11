package com.algorithm.base.heap.mergesmallfiles.pojo;

import java.io.FileOutputStream;

/**
 * @author dongfengfeng on 2020-02-10
 */
public class OutFileBusi {
    private int outIndex;

    private int maxIndex;

    private byte[] buffer;

    private String outPath;

    private FileOutputStream output;

    public OutFileBusi(int maxIndex) {
        this.maxIndex = maxIndex;
        buffer = new byte[maxIndex];
    }

    public int getOutIndex() {
        return outIndex;
    }

    public void setOutIndex(int outIndex) {
        this.outIndex = outIndex;
    }

    public int getMaxIndex() {
        return maxIndex;
    }

    public void setMaxIndex(int maxIndex) {
        this.maxIndex = maxIndex;
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public void setBuffer(byte[] buffer) {
        this.buffer = buffer;
    }

    public String getOutPath() {
        return outPath;
    }

    public void setOutPath(String outPath) {
        this.outPath = outPath;
    }

    public FileOutputStream getOutput() {
        return output;
    }

    public void setOutput(FileOutputStream output) {
        this.output = output;
    }
}
