package com.algorithm.base.recursion;

import java.io.File;

/**
 * 统计文件内存占用
 * @author dongfengfeng on 2020-02-07
 */
public class RecursionDirCount {

    public long directoryCount(File file) {
        long sum = 0;
        if (file.listFiles().length > 0) {
            if (file.isFile()) {
                sum += file.length();
            } else if (file.isDirectory()) {
                sum += directoryCount(file);
            }
        }
        return sum;
    }
}
