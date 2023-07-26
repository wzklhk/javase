package com.example.exam.jd;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(solve2(n));

    }

    private static int solve(int n) {
        if (n < 6) {
            return 0;
        } else if (n == 6) {
            return 1;
        } else {
            int m = n - 6 + 1;
            return 26 * (n - 6) * (m + (m * (m - 1)) / 2);
        }

    }

    private static int solve2(int n) {
        if (n < 6) {
            return 0;
        } else if (n == 6) {
            return 1;
        } else {
            int m = n - 6 + 1;
            double v = Math.pow(26, (n - 6)) * (m + m * (m - 1) / 2) % (Math.pow(10, 9) + 7);
            return (int) v;
        }

    }
}
