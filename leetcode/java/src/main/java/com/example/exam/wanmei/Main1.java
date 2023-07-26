package com.example.exam.wanmei;

public class Main1 {
    public static void main(String[] args) {
        Main1 p = new Main1();
        int[][] triangle = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        System.out.println(p.maximumTotal(triangle));
    }

    public int maximumTotalGreedy(int[][] triangle) {
        int n = triangle.length;
        int result = 0;

        int nextIndex = 0;
        for (int i = 0; i < n; i++) {
            result += triangle[i][nextIndex];
            if (i + 1 < n) {
                if (triangle[i + 1][nextIndex] < triangle[i + 1][nextIndex + 1]) {
                    nextIndex++;
                }
            }

        }
        return result;
    }

    public int maximumTotalGreedy2(int[][] triangle) {
        int n = triangle.length;
        int result = 0;


        for (int i = 0; i < n; i++) {
            int m = triangle[i].length;
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                max = Math.max(max, triangle[i][j]);
            }
            result += max;
        }
        return result;
    }

    public int maximumTotal(int[][] triangle) {
        int n = triangle.length;
        int result = 0;

        return result;
    }
}