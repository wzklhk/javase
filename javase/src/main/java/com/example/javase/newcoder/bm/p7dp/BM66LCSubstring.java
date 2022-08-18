package com.example.javase.newcoder.bm.p7dp;

/**
 * 最长公共子串
 * <p>
 * 描述
 * 给定两个字符串str1和str2,输出两个字符串的最长公共子串
 * 题目保证str1和str2的最长公共子串存在且唯一。
 * <p>
 * 数据范围： 1 \le |str1|,|str2| \le 50001≤∣str1∣,∣str2∣≤5000
 * 要求： 空间复杂度 O(n^2)O(n
 * 2
 * )，时间复杂度 O(n^2)O(n
 * 2
 * )
 */


public class BM66LCSubstring {
    public String lcs(String s1, String s2) {
        int ls1 = s1.length();
        int ls2 = s2.length();
        int[][] dp = new int[ls1 + 1][ls2 + 1];

        int maxLength = 0;
        int maxLastIndex = 0;
        for (int i = 1; i <= ls1; i++) {
            for (int j = 1; j <= ls2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLength) {
                        maxLength = dp[i][j];
                        maxLastIndex = i;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return s1.substring(maxLastIndex - maxLength, maxLastIndex);
    }

    public static void main(String[] args) {
        BM66LCSubstring p = new BM66LCSubstring();
        String lcs = p.lcs("abc", "abcd");
        System.out.println(lcs);
    }
}
