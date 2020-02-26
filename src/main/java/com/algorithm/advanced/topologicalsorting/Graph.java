package com.algorithm.advanced.topologicalsorting;

import java.util.LinkedList;

/**
 * @author dongfengfeng on 2020-02-23
 */
public class Graph {
    private LinkedList<Integer>[] adj;
    private int v;

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
    }

    public void kahn() {
        int[] ingree = new int[v];

        for (int i=0; i<v; i++) {
            for (int j=0; j<adj[i].size(); j++) {
                Integer point = adj[i].get(j);
                ingree[point]++;
            }
        }
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i=0; i<v; i++) {
            if (ingree[i] == 0) {
                linkedList.add(i);
            }
        }
        while (!linkedList.isEmpty()) {
            Integer rmPoint = linkedList.remove();
            for (int i=0; i<adj[rmPoint].size(); i++) {
                int k = adj[rmPoint].get(i);
                ingree[k]--;
                if (ingree[k] == 0) {
                    linkedList.add(k);
                }
            }
        }
        boolean cycleFlag = false;
        for (int i=0; i<ingree.length; i++) {
            if (ingree[i] == 0) {
                cycleFlag = true;
            }
        }
        if (cycleFlag) {
            System.out.println("图中有环");
        } else {
            System.out.println("图中无环");
        }
    }

    public void topoSortByDFS() {
        LinkedList<Integer>[] linkedList = new LinkedList[v];
        for (int i=0; i<v; i++) {
            linkedList[i] = new LinkedList<>();
        }
        for (int i=0; i<v; i++) {
            for (int j=0; j<adj[i].size(); j++) {
                Integer point = adj[i].get(j);
                linkedList[point].add(i);
            }
        }
        boolean[] visited = new boolean[v];
        for (int i=0; i<v; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                dfs(i, linkedList, visited);
            }
        }
    }
    private void dfs(int index, LinkedList<Integer>[] linkedLists, boolean[] visited) {
        for (int i=0; i<linkedLists[index].size(); i++) {
            Integer point = linkedLists[index].get(i);
            if (visited[point] == false) {
                visited[point] = true;
                dfs(point, linkedLists, visited);
            }
        }
    }
}
