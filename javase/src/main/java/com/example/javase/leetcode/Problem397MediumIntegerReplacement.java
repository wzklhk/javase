package com.example.javase.leetcode;

import org.junit.Test;

/**
 * 给定一个正整数 n ，你可以做如下操作：
 * <p>
 * <p>
 * 如果 n 是偶数，则用 n / 2替换 n 。
 * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * <p>
 * <p>
 * 返回 n 变为 1 所需的 最小替换次数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 8
 * 输出：3
 * 解释：8 -> 4 -> 2 -> 1
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 7
 * 输出：4
 * 解释：7 -> 8 -> 4 -> 2 -> 1
 * 或 7 -> 6 -> 3 -> 2 -> 1
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：n = 4
 * 输出：2
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 2³¹ - 1
 * <p>
 * <p>
 * Related Topics 贪心 位运算 记忆化搜索 动态规划 👍 253 👎 0
 */


public class Problem397MediumIntegerReplacement {

    /**
     * 枚举法
     * <p>
     * 递归求出所有，可能会导致StackOverflowError
     */
    public int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        } else if (n % 2 == 0) {
            return integerReplacement(n / 2) + 1;
        } else {
            return Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1)) + 2;
        }
    }

    /**
     * 动态规划
     * <p>
     * 通过dp数组解决递归问题，但是无法分配大数组时会出现Memory Limit Exceeded
     */
    public int integerReplacementDP(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2] + 1;
            } else {
                dp[i] = Math.min(dp[i / 2], dp[i / 2 + 1]) + 2;
            }
        }
        return dp[n];
    }

    /**
     * 贪心
     */
    public int integerReplacementGreedy(int n) {
        int ans = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                ++ans;
                n /= 2;
            } else if (n % 4 == 1) {  // n % 4 == 1
                ans += 2;
                n /= 2;
            } else {  // n % 4 == 3
                if (n == 3) {
                    ans += 2;
                    n = 1;
                } else {
                    ans += 2;
                    n = n / 2 + 1;
                }
            }
        }
        return ans;
    }

    /**
     * 测试用例
     */
    @Test
    public void test() {
        System.out.println(integerReplacementDP(7));
        System.out.println(integerReplacementDP(8));
    }
}
