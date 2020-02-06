package com.algorithm.base.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dongfengfeng on 2020-02-05
 */
public class MyGraph {
    private int v;

    private LinkedList<Integer>[] adj;

    public MyGraph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void add(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

    public void add(int s, int[] t) {
        for (int i=0; i<t.length; i++) {
            adj[s].add(t[i]);
        }
    }

    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }
        boolean[] visited = new boolean[v];
        visited[s] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        int[] pre = new int[v];
        for (int i=0; i<v; i++) {
            pre[i] = -1;
        }
        while (queue.peek() != null) {
            Integer w = queue.poll();
            for (int i=0; i<adj[w].size(); i++) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    System.out.println("当前节点为：" + q);
                    System.out.println(Arrays.toString(pre));
                    pre[q] = w;
                    if (q == t) {
                        print(pre, q, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }
    }
    private boolean found;

    public void dfs(int s, int t) {
        if (s == t) {
            return;
        }
        boolean[] visited = new boolean[v];

        int[] pre = new int[v];
        for (int i=0; i<v; i++) {
            pre[i] = -1;
        }

        print(pre, s, t);
    }

    private void recurDfs(int s, int t, boolean[] visited, int[] pre) {
        System.out.println("当前节点：" + s);
        if (found) {
            return;
        }
        visited[s] = true;
        if (s == t) {
            found = true;
            return;
        }
        for (int i=0; i<adj[s].size(); i++) {
            Integer q = adj[s].get(i);
            if (!visited[q]) {
                pre[q] = s;
                recurDfs(q, t, visited, pre);
            }
        }
    }

    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

}
