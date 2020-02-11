package com.algorithm.base.heap.mergesmallfiles;

import com.algorithm.base.heap.mergesmallfiles.pojo.OutFileBusi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author dongfengfeng on 2020-02-10
 */
public class FileOuter {
    public static final FileOuter INSTANCE = new FileOuter();

    private static final int MAX_BUFFER_SIZE = 10;

    public OutFileBusi openFile(String path) {
        OutFileBusi outfile = new OutFileBusi(MAX_BUFFER_SIZE);
        try {
            outfile.setOutput(new FileOutputStream(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return outfile;
    }

    public void writeFile(OutFileBusi outFileBusi) {
        try {
            outFileBusi.getOutput().write(outFileBusi.getBuffer(), 0, outFileBusi.getOutIndex());
            outFileBusi.getOutput().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        outFileBusi.setOutIndex(0);
    }

    public void closeFile(OutFileBusi outFileBusi) {
        if (outFileBusi.getOutput() != null) {
            try {
                outFileBusi.getOutput().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
