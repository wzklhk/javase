package com.example.javase.exam.xiecheng;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            in.nextLine();
            System.out.println(solve(a, b, c));
        }
    }

    private static int solve(int a, int b, int c) {
        int result1;
        int min = Integer.MAX_VALUE;
        min = Math.min(a, min);
        min = Math.min(b, min);
        min = Math.min(c, min);

        result1 = 2 * min;
        a -= min;
        b -= min;
        c -= min;


        int result2;
        if (b <= 1) {
            result2 = 0;
        } else if (b == 2) {
            result2 = 1;
        } else {
            result2 = b - 1;
        }
        return result1 + result2;
    }
}
