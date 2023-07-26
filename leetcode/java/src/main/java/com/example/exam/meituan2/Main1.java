package com.example.exam.meituan2;

import java.util.Scanner;

/**
 * 100%
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        System.out.println(solve(a, b));
    }

    private static int solve(int a, int b) {
        int c = a - b;
        if (b <= 9 && a <= 11) {
            return 11 - a;
        } else {
            return -c + 2;
        }
    }
}
