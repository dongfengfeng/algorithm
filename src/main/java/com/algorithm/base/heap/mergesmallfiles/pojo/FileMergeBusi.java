package com.algorithm.base.heap.mergesmallfiles.pojo;

import java.io.FileInputStream;

/**
 * @author dongfengfeng on 2020-02-10
 */
public class FileMergeBusi {

    private FileInputStream input;

    private byte[] buffer;

    private String path;

    private int bufferReadIndex;

    private int fileReadIndex;

    private boolean finish;

    public FileInputStream getInput() {
        return input;
    }

    public void setInput(FileInputStream input) {
        this.input = input;
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public void setBuffer(byte[] buffer) {
        this.buffer = buffer;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getBufferReadIndex() {
        return bufferReadIndex;
    }

    public void setBufferReadIndex(int bufferReadIndex) {
        this.bufferReadIndex = bufferReadIndex;
    }

    public int getFileReadIndex() {
        return fileReadIndex;
    }

    public void setFileReadIndex(int fileReadIndex) {
        this.fileReadIndex = fileReadIndex;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }
}
