package com.algorithm.base.charsmatch.rk;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dongfengfeng on 2020-01-28
 */
public class RabinKarp {
    private static final char[] RK_STR = {
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
        't', 'u', 'v', 'w', 'x', 'y', 'z', ' '
    };
    private static final int SCALE = RK_STR.length;
    private static final Map<Character, Integer> rkMap = new HashMap<>(RK_STR.length);

    static {
        for (int i=0; i<RK_STR.length; i++) {
            rkMap.put(RK_STR[i], i+1);
        }
    }

    /**
     * 字符串匹配算法（rk算法)
     * @param src
     * @param find
     * @return
     */
    public int find(String src, String find) {
        if (src == null || find == null) {
            return -1;
        }

        char[] srcArray = src.toCharArray();
        char[] findArray = find.toCharArray();

        int srcIndex = 0;
        long findHashValue = hashCount(findArray, 0, findArray.length);
        while (srcIndex < srcArray.length) {
            if (srcIndex + findArray.length > srcArray.length) {
                return -1;
            }
            long subHashValue = hashCount(srcArray, srcIndex, srcIndex + findArray.length);
            //当hash值相同时（hash冲突）再进行字符判断
            if (findHashValue == subHashValue) {
                if (match(srcArray, findArray, srcIndex)) {
                    return srcIndex;
                }
            }
            srcIndex++;
        }

        return -1;
    }

    /**
     * 字符匹配判断
     * @param src
     * @param find
     * @param index
     * @return
     */
    private boolean match(char[] src, char[] find, int index) {
        for (int i=0; i<find.length; i++) {
            if (src[i + index] != find[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * hash值计算
     * @param chars
     * @param start
     * @param end
     * @return
     */
    private long hashCount(char[] chars, int start, int end) {
        long result = 0L;
        for (int i=start; i<end; i++) {
            double value = Math.pow(SCALE, end - i - 1) * rkMap.get(chars[i]);
            result += value;
        }

        return result;
    }
}
