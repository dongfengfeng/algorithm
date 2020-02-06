package com.algorithm.base.hash.consistenthash;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author dongfengfeng on 2020-01-31
 */
public class ConsistentHashWithoutVirtual {
    private static String[] servers = {
            "192.168.3.1", "192.168.3.2", "192.168.99.100", "192.168.99.200"
    };
    private static SortedMap<Integer, String> SERVER_SORT_MAP = new TreeMap<>();

    static {
        for (int i=0; i<servers.length; i++) {
            int hash = HashCode.getHash(servers[i]);
            SERVER_SORT_MAP.put(hash, servers[i]);
        }
        SERVER_SORT_MAP.put(Integer.MAX_VALUE, servers[servers.length - 1]);
    }

    public String getNode(String server) {
        int hash = HashCode.getHash(server);
        SortedMap<Integer, String> subMap = SERVER_SORT_MAP.tailMap(hash);
        Integer realHash = subMap.firstKey();
        String realNode = subMap.get(realHash);
        return realNode;
    }
}
