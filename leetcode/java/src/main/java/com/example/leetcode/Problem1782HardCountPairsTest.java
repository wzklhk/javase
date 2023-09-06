package com.example.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wzklhk
 */
public class Problem1782HardCountPairsTest {
    public int[] countPairsExhaustion(int n, int[][] edges, int[] queries) {
        int m = queries.length;
        int[] answers = new int[m];
        for (int k = 0; k < m; k++) {
            for (int i = 1; i <= n - 1; i++) {
                for (int j = i + 1; j <= n; j++) {
                    int cnt = 0;
                    for (int[] edge : edges) {
                        for (int e : edge) {
                            if (e == i || e == j) {
                                cnt++;
                                break;
                            }
                        }
                    }
                    if (cnt > queries[k]) {
                        answers[k]++;
                    }
                }
            }
        }
        return answers;
    }

    public int[] countPairsExhaustion2(int n, int[][] edges, int[] queries) {
        int m = queries.length;
        int[] answers = new int[m];
        int[] cnts = new int[(n * n - 1) / 2];
        int k = 0;
        for (int i = 1; i <= n - 1; i++) {
            for (int j = i + 1; j <= n; j++) {
                int cnt = 0;
                for (int[] edge : edges) {
                    for (int e : edge) {
                        if (e == i || e == j) {
                            cnt++;
                            break;
                        }
                    }
                }
                cnts[k] = cnt;
                k++;
            }
        }

        for (int cnt : cnts) {
            for (int j = 0; j < m; j++) {
                if (cnt > queries[j]) {
                    answers[j]++;
                }
            }
        }
        return answers;
    }

    public int[] countPairs(int n, int[][] edges, int[] queries) {
        int[] degree = new int[n];
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        for (int[] edge : edges) {
            int x = edge[0] - 1, y = edge[1] - 1;
            if (x > y) {
                int temp = x;
                x = y;
                y = temp;
            }
            degree[x]++;
            degree[y]++;
            cnt.put(x * n + y, cnt.getOrDefault(x * n + y, 0) + 1);
        }

        int[] arr = Arrays.copyOf(degree, n);
        int[] ans = new int[queries.length];
        Arrays.sort(arr);
        for (int k = 0; k < queries.length; k++) {
            int bound = queries[k], total = 0;
            for (int i = 0, j = n - 1; i < n; i++) {
                while (j > i && arr[i] + arr[j] > bound) {
                    j--;
                }
                total += n - 1 - Math.max(i, j);
            }
            for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
                int val = entry.getKey(), freq = entry.getValue();
                int x = val / n, y = val % n;
                if (degree[x] + degree[y] > bound && degree[x] + degree[y] - freq <= bound) {
                    total--;
                }
            }
            ans[k] = total;
        }

        return ans;
    }

    @Test
    public void test() {
        int n = 4;
        int[][] edges = {{1, 2}, {2, 4}, {1, 3}, {2, 3}, {2, 1}};
        int[] queries = {2, 3};
        int[] ints = countPairs(n, edges, queries);
        System.out.println(Arrays.toString(ints));
    }

    @Test
    public void test2() {
        int n = 5;
        int[][] edges = {{1, 5}, {1, 5}, {3, 4}, {2, 5}, {1, 3}, {5, 1}, {2, 3}, {2, 5}};
        int[] queries = {1, 2, 3, 4, 5};
        int[] ints = countPairsExhaustion2(n, edges, queries);
        System.out.println(Arrays.toString(ints));
    }
}
