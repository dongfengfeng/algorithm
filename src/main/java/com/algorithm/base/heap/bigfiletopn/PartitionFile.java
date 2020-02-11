package com.algorithm.base.heap.bigfiletopn;

import com.algorithm.base.heap.bigfiletopn.pojo.PartitionBusi;
import com.algorithm.utils.IOUtil;
import sun.misc.IOUtils;

import java.io.*;

/**
 * @author dongfengfeng on 2020-02-11
 */
public class PartitionFile {

    public static final PartitionFile INSTANCE = new PartitionFile();

    private static final int MAX_PATITION_SIZE = 64;

    private static final String PARTITION_DIR_NAME = "partitino";

    private static final String SUFFIX_NAME = ".buffer";

    public PartitionBusi[] getPartition(String basePath) {
        PartitionBusi[] result = new PartitionBusi[MAX_PATITION_SIZE];

        File baseFile = new File(basePath + File.separator + PARTITION_DIR_NAME);
        if (baseFile.exists()) {
            File[] files = baseFile.listFiles();
            for (int i=0; i<files.length; i++) {
                files[i].delete();
            }

        }
        baseFile.mkdir();

        for (int i=0; i<MAX_PATITION_SIZE; i++) {
            PartitionBusi partitionBusi = new PartitionBusi();
            partitionBusi.setIndex(i);
            String path = baseFile.getPath() + File.separator + i + SUFFIX_NAME;
            partitionBusi.setPath(path);
            try {
                partitionBusi.setFileWriter(new FileWriter(path));
                partitionBusi.setBufferedWriter(new BufferedWriter(partitionBusi.getFileWriter()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public void writeData(PartitionBusi partitionBusi, String data) {
        try {
            partitionBusi.getBufferedWriter().write(data);
            partitionBusi.getBufferedWriter().newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeWriter(PartitionBusi[] partitionBusis) {
        for (int i=0; i<partitionBusis.length; i++) {
            IOUtil.close(partitionBusis[i].getFileWriter());
            IOUtil.close(partitionBusis[i].getBufferedWriter());
        }
    }

    public void openReader(PartitionBusi partitionBusi) {
        try {
            partitionBusi.setFileReader(new FileReader(partitionBusi.getPath()));
            partitionBusi.setBufferedReader(new BufferedReader(partitionBusi.getFileReader()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void closeReader(PartitionBusi partitionBusi) {
        IOUtil.close(partitionBusi.getFileReader());
        IOUtil.close(partitionBusi.getBufferedReader());
    }
}
