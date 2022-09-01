package com.example.javase.algorithms.graph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphTest {


    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 0, 0, 0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 1, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 1, 0, 1, 1, 1},
                {0, 0, 0, 1, 0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 1, 0, 1, 0, 0},
                {0, 1, 1, 1, 0, 0, 0, 0, 0}
        };
        boolean[] isVisited = new boolean[graph.length];
        dfs(graph, 0, isVisited);
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

    public static void bfs(int[][] graph) {
        int length = graph.length;
        boolean[] isVisited = new boolean[length];
        Queue<Integer> queue = new LinkedList<>();
    }
}
