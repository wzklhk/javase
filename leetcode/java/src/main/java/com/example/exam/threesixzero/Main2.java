package com.example.exam.threesixzero;

import java.util.*;

// 最小生成树
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();

        int[] u = new int[m];
        for (int i = 0; i < m; i++) {
            u[i] = in.nextInt() - 1;
        }
        in.nextLine();
        int[] v = new int[m];
        for (int i = 0; i < m; i++) {
            v[i] = in.nextInt() - 1;
        }
        in.nextLine();
        int[] w = new int[m];
        for (int i = 0; i < m; i++) {
            w[i] = in.nextInt();
        }
        in.nextLine();

        System.out.println(solve(n, u, v, w));
    }

    private static int solve(int n, int[] u, int[] v, int[] w) {
        int m = u.length;
        boolean[] isVisited = new boolean[n];
        List<List<Integer>> graphs = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(Math.min(u[i], v[i]));
            list.add(Math.max(u[i], v[i]));
            list.add(w[i]);
            graphs.add(list);
        }
        Collections.sort(graphs, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(2) - o2.get(2);
            }
        });

        int result = 0;
        for (int i = 0; i < graphs.size(); i++) {
            Integer ui = graphs.get(i).get(0);
            Integer vi = graphs.get(i).get(1);
            if (!(isVisited[ui] && isVisited[vi])) {
                isVisited[ui] = true;
                isVisited[vi] = true;
                result += graphs.get(i).get(2);
            }
        }

        return result;
    }
}
