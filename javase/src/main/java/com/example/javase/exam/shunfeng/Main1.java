package com.example.javase.exam.shunfeng;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int func = func(n);
        System.out.println(func % 1000000007);
    }

    private static int func(int n) {
        if (n <= 3) {
            return 1;
        } else {
            return 1 + func(n - 1) % 1000000007 + func(n - 2) % 1000000007 + func(n - 3) % 1000000007;
        }
    }
}
