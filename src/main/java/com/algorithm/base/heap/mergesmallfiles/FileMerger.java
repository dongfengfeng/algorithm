package com.algorithm.base.heap.mergesmallfiles;

import com.algorithm.base.heap.mergesmallfiles.pojo.FileMergeBusi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author dongfengfeng on 2020-02-10
 */
public class FileMerger {
    public static final FileMerger INSTANCE = new FileMerger();

    private static final int MAX_BUFFER_SIZE = 10;

    public FileMergeBusi openFile(File file) {
        FileMergeBusi mergeBean = new FileMergeBusi();
        if (file.exists()) {
            try {
                mergeBean.setInput(new FileInputStream(file));
                mergeBean.setPath(file.getPath());
                mergeBean.setBuffer(new byte[MAX_BUFFER_SIZE]);
                mergeBean.setBufferReadIndex(0);
                mergeBean.setFileReadIndex(0);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return mergeBean;
    }

    public void readFile(FileMergeBusi bean) {
        if (!bean.isFinish()) {
            try {
                int readLength = bean.getInput().read(bean.getBuffer());
                bean.setFileReadIndex(readLength);
                bean.setBufferReadIndex(0);
                if (readLength == -1) {
                    bean.setFinish(true);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeFile(FileMergeBusi[] fileMergeBusis) {
        try {
            for (int i=0; i<fileMergeBusis.length; i++) {
                fileMergeBusis[i].getInput().close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
