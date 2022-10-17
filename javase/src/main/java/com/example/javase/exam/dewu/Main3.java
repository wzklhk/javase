package com.example.javase.exam.dewu;

import org.junit.Test;


/**
 * 求n被25、10、5、1分解的方法数
 */
public class Main3 {
    public int countWays(int n) {

        // write code here
        int[] coins = {1, 5, 10, 25};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < 4; ++i) {
            for (int j = coins[i]; j <= n; ++j) {
                dp[j] = (dp[j] + dp[j - coins[i]]) % 1000000007;
            }
        }
        return dp[n];
    }

    @Test
    public void test() {
        System.out.println(countWays(25));
    }
}
