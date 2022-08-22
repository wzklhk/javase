package com.example.javase.newcoder.netease2021;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        in.nextLine();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            in.nextLine();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[i] = in.nextInt();
            }

            in.nextLine();
        }
    }

}
