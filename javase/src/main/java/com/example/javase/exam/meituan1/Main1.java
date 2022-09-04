package com.example.javase.exam.meituan1;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();

        String ns = in.nextLine();
        String ms = in.nextLine();

        System.out.println(solve(ns, ms));

    }

    private static int solve(String ns, String ms) {
        int result = 0;

        int n = ns.length();
        int m = ms.length();

        for (int i = 0; i < n - m + 1; i++) {
            String substring = ns.substring(i, i + m);
            if (isMatch(substring, ms)) {
                result++;
            }
        }

        return result;
    }

    private static boolean isMatch(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            if (str2.charAt(i) == '*') {
                continue;
            } else if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
