package com.example.javase.exam.dianxin;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int h = in.nextInt();
        if (n >= m) {
            System.out.println("error");
            return;
        }
        int[] ans = solve(n, m, h);
        System.out.println(ans[0] + "\\" + ans[1]);
    }

    private static int[] solve(int n, int m, int h) {
        int[] ans = new int[2];
        int sum = 0;
        for (int i = n; i <= m; i++) {
            if (isPrim(i)) {
                sum += i;
            }
            if (sum > h) {
                ans[0] = i;
                ans[1] = sum;
                break;
            }
        }
        return ans;
    }

    private static boolean isPrim(int n) {
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}