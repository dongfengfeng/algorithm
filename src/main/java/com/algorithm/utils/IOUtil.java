package com.algorithm.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author dongfengfeng on 2020-02-11
 */
public class IOUtil {
    public static void close(Closeable stream) {
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
