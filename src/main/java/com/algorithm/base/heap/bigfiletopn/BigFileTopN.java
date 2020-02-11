package com.algorithm.base.heap.bigfiletopn;

import com.algorithm.base.hash.consistenthash.HashCode;
import com.algorithm.base.heap.bigfiletopn.pojo.KeyBusi;
import com.algorithm.base.heap.bigfiletopn.pojo.PartitionBusi;
import com.algorithm.utils.IOUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dongfengfeng on 2020-02-11
 */
public class BigFileTopN {

    private static final String SPIT_FLAG = " ";

    public KeyBusi[] topN(String path, int n) {
        List<KeyBusi[]> list = new ArrayList<>();
        File file = new File(path);

        PartitionBusi[] partitions = PartitionFile.INSTANCE.getPartition(file.getParent());
        fileToPartition(path, partitions);

        PartitionFile.INSTANCE.closeWriter(partitions);

        list = countTopN(partitions, n);

        KeyBusi[] topN = CountTopN.INSTANCE.getTopN(list, n);

        return topN;
    }

    private List<KeyBusi[]> countTopN(PartitionBusi[] partitionBusis, int n) {
        List<KeyBusi[]> list = new ArrayList<>();

        for (int i=0; i<partitionBusis.length; i++) {
            PartitionFile.INSTANCE.openReader(partitionBusis[i]);
            String line = null;
            try {
                while ((line = partitionBusis[i].getBufferedReader().readLine()) != null) {
                    CountTopN.INSTANCE.putData(line);
                }

                list.add(CountTopN.INSTANCE.getTopN(n));

                CountTopN.INSTANCE.clearData();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                PartitionFile.INSTANCE.closeReader(partitionBusis[i]);
            }
        }
        return list;
    }

    private void fileToPartition(String file, PartitionBusi[] partitionBusis) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                lineToPartition(line, partitionBusis);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtil.close(bufferedReader);
            IOUtil.close(fileReader);
        }
    }

    private void lineToPartition(String line, PartitionBusi[] partitionBusis) {
        int index = 0;
        int findIndex;
        line = line.trim();

        while (index < line.length()) {
            if ((findIndex = line.indexOf(SPIT_FLAG, index)) != -1) {
                String key = line.substring(index, findIndex);
                keyToPartition(key, partitionBusis);
                index = findIndex + 1;
            } else {
                String key = line.substring(index);
                keyToPartition(key, partitionBusis);
                index += line.length();
            }
        }
    }

    private void keyToPartition(String key, PartitionBusi[] partitionBusis) {
        int length = partitionBusis.length;
        int hash = HashCode.getHash(key);
        int partitionIndex = hash % length;
        PartitionFile.INSTANCE.writeData(partitionBusis[partitionIndex], key);
    }
}
