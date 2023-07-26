package com.example.newcoder.bm.p7dp;

public class BM62Fibonacci {
    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int a = 0, b = 1, c = 1;
            for (int i = 2; i <= n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }

    public int fibonacciDP(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        BM62Fibonacci p = new BM62Fibonacci();

        int res = p.fibonacci(4);
        System.out.println(res);
    }
}
