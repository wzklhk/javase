package com.example.exam.tencent;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        int r = in.nextInt();
        System.out.println(solve2(l, r));
    }

    private static int solve(int l, int r) {
        StringBuilder sb = new StringBuilder();
        sb.append("10");
        while (sb.length() < r) {
            sb.append(reverse(sb.toString()));
        }
        String substring = sb.substring(l - 1, r);
        return count(substring);
    }

    private static int solve2(int l, int r) {
        int result = 0;
        for (int i = l; i <= r; i++) {
            if (num(i) == 1) {
                result++;
            }

        }
        return result;
    }

    private static int num(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 0;
        }
        int tmp = 0;
        for (int i = 0; n > Math.pow(2, i); i++) {
            tmp = (int) Math.pow(2, i);
        }
        if (num(n - tmp) == 1) {
            return 0;
        } else {
            return 1;
        }
    }

    private static String reverse(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        return sb.toString();
    }

    private static int count(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                result++;
            }
        }
        return result;
    }

}
