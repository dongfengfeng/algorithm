package com.algorithm.advanced.bloomfilter;

/**
 * @author dongfengfeng on 2020-02-23
 */
public class BloomFilter {
    private int HASH_NUM = 5;

    private BitMap bitMap = new BitMap(Integer.MAX_VALUE);

    public int[] getHashArrays(String url) {
        int[] hashArrays = new int[HASH_NUM];
        hashArrays[0] = Math.abs(HashAlgorithms.PJWHash(url));
        hashArrays[1] = Math.abs(HashAlgorithms.APHash(url));
        hashArrays[2] = Math.abs(HashAlgorithms.BKDRHash(url));
        hashArrays[3] = Math.abs(HashAlgorithms.DEKHash(url));
        hashArrays[4] = Math.abs(HashAlgorithms.JSHash(url));
        return hashArrays;
    }

    public void putUrl(String url) {
        int[] hashArrays = getHashArrays(url);
        boolean exists = exists(hashArrays);
        if (!exists) {
            for (int i=0; i<HASH_NUM; i++) {
                bitMap.set(hashArrays[i]);
            }
        }
    }

    public boolean exists(String key) {
        int[] hashArrays = getHashArrays(key);
        return exists(hashArrays);
    }

    private boolean exists(int[] hashArrays) {
        boolean result = false;
        for (int i=0; i<HASH_NUM; i++) {
            boolean r = bitMap.get(hashArrays[i]);
            if (r) {
                result = true;
                break;
            }
        }
        return result;

        //上面的判断条件是否反了？
        /*boolean result = true;
        for (int i=0; i<HASH_NUM; i++) {
            boolean r = bitMap.get(hashArrays[i]);
            if (!r) {
                result = false;
                break;
            }
        }
        return result;*/
    }
}
