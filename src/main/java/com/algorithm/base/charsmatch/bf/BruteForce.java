package com.algorithm.base.charsmatch.bf;
/**
 * @author dongfengfeng on 2020-01-26
 */
public class BruteForce {

    public int find(String src, String find) {
        if (src == null || find == null) {
            return -1;
        }
        char[] srcArray = src.toCharArray();
        char[] findArray = find.toCharArray();

        int srcIndex = 0;

        while (srcIndex < srcArray.length) {
            if (srcIndex + findArray.length > srcArray.length) {
                return -1;
            }
            int findIndex = -1;
            for (int i=0; i<findArray.length; i++) {
                if (srcArray[srcIndex + i] == findArray[i]) {
                    if (findIndex == -1) {
                        findIndex = srcIndex + i;
                    }
                    continue;
                } else {
                    findIndex = -1;
                    break;
                }
            }
            if (findIndex != -1) {
                return findIndex;
            }
            srcIndex++;
        }
        return -1;
    }
}
