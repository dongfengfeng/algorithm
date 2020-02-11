package com.algorithm.base.heap.mergesmallfiles;

import com.algorithm.base.heap.mergesmallfiles.pojo.ByteHeadInfo;
import com.algorithm.base.heap.mergesmallfiles.pojo.FileMergeBusi;
import com.algorithm.base.heap.mergesmallfiles.pojo.OutFileBusi;

import java.io.File;
import java.util.PriorityQueue;

/**
 * @author dongfengfeng on 2020-02-10
 */
public class MergeProcessor {

    public FileMergeBusi[] getMergeBean(String path) {
        FileMergeBusi[] result = null;

        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            for (int i=0; i<files.length; i++) {
                result[i] = FileMerger.INSTANCE.openFile(files[i]);
            }
        }
        return result;
    }

    public void read(FileMergeBusi[] mergeFiles, String outPath) {
        for (int i=0; i<mergeFiles.length; i++) {
            FileMerger.INSTANCE.readFile(mergeFiles[i]);
        }

        PriorityQueue<ByteHeadInfo> smallHeap = new PriorityQueue<>(mergeFiles.length, (o1, o2) -> {
            if (o1.getValue() > o2.getValue()) {
                return 1;
            } else if (o1.getValue() < o2.getValue()) {
                return -1;
            } else {
                return 0;
            }
        });

        for (int i=0; i<mergeFiles.length; i++) {
            if (mergeFiles[i].getBufferReadIndex() < mergeFiles[i].getFileReadIndex()) {
                smallHeap.offer(new ByteHeadInfo(mergeFiles[i].getBuffer()[mergeFiles[i].getBufferReadIndex()], i));
                mergeFiles[i].setBufferReadIndex(mergeFiles[i].getBufferReadIndex() + 1);
            }
        }

        OutFileBusi outFile = FileOuter.INSTANCE.openFile(outPath);

        ByteHeadInfo curByte;

        while (!checkFinish(mergeFiles) || !smallHeap.isEmpty()) {
            curByte = smallHeap.poll();
            if (outFile.getOutIndex() < outFile.getMaxIndex()) {
                outFile.getBuffer()[outFile.getOutIndex()] = curByte.getValue();
                outFile.setOutIndex(outFile.getOutIndex() + 1);
            }
            if (outFile.getOutIndex() == outFile.getMaxIndex()) {
                FileOuter.INSTANCE.writeFile(outFile);
            }
            readFileNextByte(mergeFiles[curByte.getIndex()], curByte.getIndex(), smallHeap);
        }
        FileOuter.INSTANCE.writeFile(outFile);

        FileMerger.INSTANCE.closeFile(mergeFiles);

        FileOuter.INSTANCE.closeFile(outFile);

    }
    private void readFileNextByte(FileMergeBusi mergeFile, int index, PriorityQueue<ByteHeadInfo> smallHeap) {
        if (mergeFile.getBufferReadIndex() < mergeFile.getFileReadIndex()) {
            smallHeap.offer(new ByteHeadInfo(mergeFile.getBuffer()[mergeFile.getBufferReadIndex()], index));
            mergeFile.setBufferReadIndex(mergeFile.getBufferReadIndex() + 1);
        }
        if (mergeFile.getBufferReadIndex() == mergeFile.getFileReadIndex()) {
            FileMerger.INSTANCE.readFile(mergeFile);
        }
    }

    private boolean checkFinish(FileMergeBusi[] mergeBusis) {
        for (int i=0; i<mergeBusis.length; i++) {
            if (!mergeBusis[i].isFinish()) {
                return false;
            }
        }
        return true;
    }

}
