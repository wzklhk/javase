package com.example.javase.algorithms.graph;

import com.example.javase.algorithms.tree.TreeNode;
import com.sun.corba.se.impl.orbutil.graph.GraphImpl;

import java.util.ArrayDeque;
import java.util.Deque;

public class GraphTest {

    public static void main(String[] args) {

        /*
         * 0 - 1   2 - 3
         * |   | / | / |
         * 4   5 - 6 - 7
         */
        int[][] graph = {
                {0, 1, 0, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 1, 1, 0},
                {0, 0, 1, 0, 0, 0, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 0, 1, 0},
                {0, 0, 1, 1, 0, 1, 0, 1},
                {0, 0, 0, 1, 0, 0, 1, 0},
        };
        boolean[] isVisited = new boolean[graph.length];
        bfs(graph, 0);

        GraphImpl g1 = new GraphImpl();
        TreeNode treeNode = new TreeNode(1);
    }

    public static void dfs(int[][] graph, int index, boolean[] isVisited) {
        int length = graph.length;

        if (isVisited[index]) {
            return;
        }

        System.out.println(index + 1);
        isVisited[index] = true;

        for (int i = 1; i < length; i++) {
            if (graph[index][i] == 1) {
                dfs(graph, i, isVisited);
            }
        }
    }

    public static void bfs(int[][] g, int s) {
        int length = g.length;
        boolean[] isVisited = new boolean[length];
        isVisited[s] = true;
        Deque<Integer> q = new ArrayDeque<>();

        System.out.println(s);
        q.add(s);
        while (q.size() != 0) {
            int u = q.remove();
            for (int i = 0; i < length; i++) {
                if (g[u][i] != 0 && !isVisited[i]) {
                    isVisited[i] = true;
                    System.out.println(i);
                    q.add(i);
                }
            }
        }
    }
}
