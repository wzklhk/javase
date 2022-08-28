package com.example.javase.exam.jd;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        in.nextLine();

        String str = in.nextLine();

        System.out.println(solve(str, k));

    }

    private static String solve(String str, int k) {
        String s1 = str.substring(0, k).toUpperCase();
        String s2 = str.substring(k).toLowerCase();
        return s1 + s2;
    }
}
