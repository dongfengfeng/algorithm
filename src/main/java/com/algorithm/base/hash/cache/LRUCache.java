package com.algorithm.base.hash.cache;

/**
 * @author dongfengfeng on 2020-01-31
 */
public class LRUCache {

    private Data[] datas;
    private Data head = new Data();
    private Data tail = head;
    private int capacity;
    private int size;
    private final int MAX_CACHE;

    public LRUCache(int capacity, int MAX_CACHE) {
        this.capacity = capacity;
        this.MAX_CACHE = MAX_CACHE;
    }

    public int size() {
        return size;
    }

    public void put(String key, String value) {
        int index = hash(key);
        Data data = new Data();
        data.key = key;
        data.value = value;

        if (datas[index] == null) {
            datas[index] = new Data();
        }

        Data findData = findData(key, index);
        if (findData != null) {
            findData.value = value;
        } else {
            if (datas[index].hnext == null) {
                datas[index].hnext = data;
            } else {
                Data tail = getTail(index);
                data.hnext = tail.hnext;
                tail.hnext = data;
            }
        }
        lrulink(findData, data);
    }

    public void delete(String key) {
        int index = hash(key);
        Data data = findData(key, index);
        Data hashPre = findHashPre(data);
        hashPre.next = data.next;

        data.pre.next = data.next;
        if (data.next != null) {
            data.next.pre = data.pre;
        }
        data.next = null;
        data.pre = null;
        data.hnext = null;
        size--;
    }

    public String get(String key) {
        int index = hash(key);
        Data findData = datas[index].hnext;
        while (findData != null) {
            if (findData.key == key) {
                break;
            }
            findData = findData.hnext;
        }

        if (findData != null) {
            findData.pre.next = findData.next;
            findData.next.pre = findData.pre;
            findData.next = null;

            tail.next = findData;
            findData.pre = tail;
            tail = findData;

            return findData.value;
        }
        return null;
    }

    private void lrulink(Data findData, Data insertData) {

        if (findData != null) {
            findData.pre.next = findData.next;

            insertData.pre = tail;
            tail.next = insertData;
            tail = insertData;
        }
        else {
            if (size >= MAX_CACHE) {
                Data hashPre = findHashPre(head.next);
                if (hashPre != null) {
                    hashPre.hnext =head.next.hnext;
                }
                if (head.next != null) {
                    head.next = head.next.next;
                    head.next.pre = head;
                    size--;
                }
            }
            insertData.pre = tail;
            tail.next = insertData;
            tail = insertData;
            size++;
        }
    }

    private Data findHashPre(Data data) {
        Data findData = datas[hash(data.key)];
        while (findData != null) {
            if (findData.hnext.key == data.key) {
                return findData;
            }
            findData = findData.hnext;
        }
        return null;
    }

    private Data getTail(int index) {
        Data data = datas[index];
        while (data != null) {
            data = data.hnext;
        }
        return data;
    }

    private Data findData(String key, int index) {
        Data data = datas[index];
        while (data != null) {
            if (data.key == key) {
                return data;
            }
            data = data.next;
        }
        return null;
    }

    private int hash(String key) {
        int h = key.hashCode();
        return (h ^ (h >>> 16)) & (capacity - 1);
    }

    class Data {
        private String key;
        private String value;
        private Data pre;
        private Data next;
        private Data hnext;
    }
}
