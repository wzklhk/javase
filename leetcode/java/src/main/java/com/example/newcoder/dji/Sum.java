package com.example.newcoder.dji;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            double sum = sum(n, m);
            System.out.printf("%.2d\n", sum);
            in.nextLine();
        }
    }

    public static double sum(int n, int m) {
        double result = 0;

        double nd = n;

        for (int i = 0; i < m; i++) {
            result += nd;
            nd = Math.sqrt((double) nd);
        }

        return result;
    }

}
