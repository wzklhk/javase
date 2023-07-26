package com.example.exam.dianxin;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = in.nextInt();
            }
            in.nextLine();
        }

        System.out.println(solve(matrix));
    }

    private static int solve(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        dp[0][0] = matrix[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(matrix[i][j] + dp[i - 1][j], matrix[i][j] + dp[i][j - 1]);
            }
        }

        return dp[n - 1][n - 1];
    }
}
