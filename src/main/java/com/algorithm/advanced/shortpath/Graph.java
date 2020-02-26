package com.algorithm.advanced.shortpath;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @author dongfengfeng on 2020-02-23
 */
public class Graph {


    private int v;

    private LinkedList<Edge>[] adj;

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void dijkstra(int s, int t) {
        Vertex[] vertices = new Vertex[v];
        for (int i=0; i<v; i++) {
            vertices[i] = new Vertex(i, Integer.MAX_VALUE);
        }

        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        queue.add(vertices[s]);

        boolean[] inqueue = new boolean[v];

        vertices[s].dis = 0;
        inqueue[s] = true;

        while (!queue.isEmpty()) {
            Vertex p = queue.poll();

            if (p.id == t) {
                break;
            }

            for (int i=0; i<adj[p.id].size(); i++) {
                Edge edge = adj[p.id].get(i);
                Vertex next = vertices[edge.tid];
                if (p.dis + edge.w < next.dis) {
                    next.dis = p.dis + edge.w;
                    if (inqueue[next.id] == false) {
                        inqueue[next.id] = true;
                        queue.add(next);
                    }
                }
            }
        }
    }

    private class Edge {
        public int sid;
        public int tid;
        public int w;

        public Edge(int sid, int tid, int w) {
            this.sid = sid;
            this.tid = tid;
            this.w = w;
        }
    }

    private class Vertex implements Comparable<Vertex> {
        public int id;
        public int dis;

        public Vertex(int id, int dis) {
            this.id = id;
            this.dis = dis;
        }

        @Override
        public int compareTo(Vertex o) {
            if (dis > o.dis) {
                return 1;
            }
            return -1;
        }
    }
}
