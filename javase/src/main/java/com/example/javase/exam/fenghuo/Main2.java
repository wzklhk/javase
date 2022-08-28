package com.example.javase.exam.fenghuo;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        System.out.println(solve(n, m, k));
    }

    private static int solve(int n, int m, int k) {
        int[][] mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = gcd(i + 1, j + 1);
            }
        }

        int result = 0;

        for (int i = 0; i <= n - k; i++) {
            for (int j = 0; j <= m - k; j++) {
                for (int i1 = i; i1 < i + k; i1++) {
                    for (int j1 = j; j1 < j + k; j1++) {
                        result += mat[i1][j1];
                    }
                }
            }
        }
        return result;
    }

    private static int gcd(int i, int j) {
        return i % j == 0 ? j : gcd(j, i % j);

    }
}
