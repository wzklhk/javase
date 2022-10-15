package com.example.javase.exam.wanmei;

import java.util.HashSet;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
        Main2 p = new Main2();
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}, {4, 1, 1}};

        System.out.println(p.networkDelayTime(times, 4, 2));
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] graph = new int[n + 1][n + 1];
        for (int i = 0; i < times.length; i++) {
            graph[times[i][0]][times[i][1]] = times[i][2];
        }
        HashSet<Integer> visited = new HashSet<>();
        int result = bfs(graph, visited, k);

        if (visited.size() < n) {
            return -1;
        }
        return result;
    }

    private int bfs(int[][] graph, Set<Integer> visited, int k) {
        if (visited.contains(k)) {
            return 0;
        }

        visited.add(k);

        int n = graph.length - 1;
        int maxLength = 0;
        for (int i = 1; i <= n; i++) {
            if (graph[k][i] != 0) {
                int length = graph[k][i] + bfs(graph, visited, i);
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;

    }
}
