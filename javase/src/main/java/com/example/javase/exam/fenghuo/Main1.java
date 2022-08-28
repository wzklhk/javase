package com.example.javase.exam.fenghuo;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        System.out.println(solve(a, b, c));
    }

    private static int solve(int a, int b, int c) {
        int sum = a + b;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= sum / 2; i++) {
            int a1 = i;
            int b1 = sum - i;
            if ((a1 / c + b1 / c) >= max) {
                max = (a1 / c + b1 / c);
                min = Math.min(Math.abs(a1 - a) + Math.abs(b1 - b), min);
            }
        }

        return min;
    }

    private static int solve2(int a, int b, int c) {
        int sum = a + b;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= sum; i++) {
            int a1 = i;
            int b1 = sum - i;
            min = Math.min(Math.abs(a1 - a) + Math.abs(b1 - b), min);

        }

        return min;
    }
}
