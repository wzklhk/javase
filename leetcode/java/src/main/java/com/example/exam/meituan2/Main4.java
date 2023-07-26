package com.example.exam.meituan2;

import java.util.Scanner;

/**
 * 82% 结果错误
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        int[] c = new int[m];
        for (int i = 0; i < m; i++) {
            c[i] = in.nextInt();
        }
        in.nextLine();

        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = in.nextInt();
        }
        in.nextLine();

        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = in.nextInt();
        }
        in.nextLine();

        System.out.println(solve(c, a, b, k));

    }

    private static int solve(int[] c, int[] a, int[] b, int k) {
        int m = c.length;

        int[][] dp = new int[2][m + 1];
        int[][] location = new int[2][m + 1];
        location[0][0] = k;
        location[1][0] = k;

        for (int i = 0; i < m; i++) {
            int preLoc0 = location[0][i];
            int preLoc1 = location[1][i];

            // 完成任务
            location[0][i + 1] = c[i];

            int score1;
            if (c[i] == location[0][i]) {
                score1 = dp[0][i] + a[i];
            } else {
                score1 = dp[0][i] + b[i];
            }

            int score2;
            if (c[i] == location[1][i]) {
                score2 = dp[1][i] + a[i];
            } else {
                score2 = dp[1][i] + b[i];
            }
            dp[0][i + 1] = Math.max(score1, score2);

            // 放弃任务
            if (dp[0][i] > dp[1][i]) {
                location[1][i + 1] = location[0][i];
                dp[1][i + 1] = dp[0][i];
            } else {
                location[1][i + 1] = location[1][i];
                dp[1][i + 1] = dp[1][i];
            }
        }

        return Math.max(dp[0][m], dp[1][m]);

    }
}
