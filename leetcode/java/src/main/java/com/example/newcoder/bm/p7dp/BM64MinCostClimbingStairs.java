package com.example.newcoder.bm.p7dp;

/**
 * 给定一个整数数组 cost \cost  ，其中 cost[i]\cost[i]  是从楼梯第i \i 个台阶向上爬需要支付的费用，下标从0开始。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * <p>
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * <p>
 * 请你计算并返回达到楼梯顶部的最低花费。
 * <p>
 * 数据范围：数组长度满足 1 \le n \le 10^5 \1≤n≤10
 * 5
 * ，数组中的值满足 1 \le cost_i \le 10^4 \1≤cost
 * i
 * ​
 * ≤10
 * 4
 */
public class BM64MinCostClimbingStairs {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param cost int整型一维数组
     * @return int整型
     */
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }
}
