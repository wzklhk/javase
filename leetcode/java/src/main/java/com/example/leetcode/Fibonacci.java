package com.example.leetcode;

public class Fibonacci {

    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            System.out.printf("%d\t\t\t%d\t\t\t%f\n", i, fab1(i), Math.pow(2, i));
        }
    }

    private static Integer fab(Integer n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fab(n - 1) + fab(n - 2);
    }

    private static Long fab1(Integer n) {
        if (n == 0) {
            return 0L;
        }
        if (n == 1) {
            return 1L;
        }
        Long num1 = 0L;
        Long num2 = 1L;
        for (int i = 2; i < n; i++) {
            num2 = num1 + num2;
            num1 = num2 - num1;
        }
        return num2;
    }
}
