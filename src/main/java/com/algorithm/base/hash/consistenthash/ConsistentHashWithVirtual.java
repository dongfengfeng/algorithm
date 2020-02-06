package com.algorithm.base.hash.consistenthash;

import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author dongfengfeng on 2020-01-31
 */
public class ConsistentHashWithVirtual {
    private static String[] servers = {
            "192.168.3.1:8080", "192.168.3.2:8081", "192.168.99.100:8083", "192.168.99.200:80"
    };

    private static final List<String> SERVER_NODE = new LinkedList<>();

    private static final SortedMap<Integer, String> VIRTUAL_MAP = new TreeMap<>();

    private static final int VIRTUAL_NUM = 20;

    static {
        for (int i=0; i<servers.length; i++) {
            SERVER_NODE.add(servers[i]);
        }
        for (String serverIp : SERVER_NODE) {
            for (int i=0; i<VIRTUAL_NUM; i++) {
                String virtualId = serverIp + "_" + i;
                VIRTUAL_MAP.put(HashCode.getHash(virtualId), serverIp);
            }
        }
        VIRTUAL_MAP.put(Integer.MAX_VALUE, servers[servers.length - 1]);
    }

    public void addNode(String serverIp) {
        for (int i=0; i<VIRTUAL_NUM; i++) {
            String virtualId = serverIp + "_" + i;
            VIRTUAL_MAP.put(HashCode.getHash(virtualId), serverIp);
        }
    }

    public void removeNode(String serverIp) {
        for (int i=0; i<VIRTUAL_NUM; i++) {
            String virtualId = serverIp + "_" + i;
            VIRTUAL_MAP.remove(virtualId);
        }
    }

    public String getNode(String req) {
        int hash = HashCode.getHash(req);
        SortedMap<Integer, String> sortedMap = VIRTUAL_MAP.tailMap(hash);
        Integer realHash = sortedMap.firstKey();
        return sortedMap.get(realHash);
    }
}
