package com.example.javase.newcoder.bm.p7dp;

/**
 * 最长公共子序列
 * <p>
 * 描述
 * 给定两个字符串str1和str2，输出两个字符串的最长公共子序列。如果最长公共子序列为空，则返回"-1"。目前给出的数据，仅仅会存在一个最长的公共子序列
 * <p>
 * 数据范围：0 \le |str1|,|str2| \le 20000≤∣str1∣,∣str2∣≤2000
 * 要求：空间复杂度 O(n^2)O(n
 * 2
 * ) ，时间复杂度 O(n^2)O(n
 * 2
 * )
 */

public class BM65LCSubSequence {
    public String lcs(String s1, String s2) {
        int ls1 = s1.length();
        int ls2 = s2.length();
        int[][] dp = new int[ls1 + 1][ls2 + 1];
        // ↖为1，←为2，↑为3
        int[][] b = new int[ls1 + 1][ls2 + 1];

        for (int i = 1; i <= ls1; i++) {
            for (int j = 1; j <= ls2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    b[i][j] = 1;  // 左上
                } else if (dp[i - 1][j] > dp[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j];
                    b[i][j] = 2;  // 左边
                } else {
                    dp[i][j] = dp[i][j - 1];
                    b[i][j] = 3;  // 上边
                }
            }
        }
        String s = returnLCS(b, s1, s1.length(), s2.length());
        if (s.length() > 0) {
            return s;
        } else {
            return "-1";
        }
    }

    private String returnLCS(int[][] b, String x, int i, int j) {
        String res = "";
        if (i == 0 || j == 0)
            return res;
        //根据方向，往前递归，然后添加本级字符
        if (b[i][j] == 1) { // 左上
            res += returnLCS(b, x, i - 1, j - 1);
            res += x.charAt(i - 1);
        } else if (b[i][j] == 2) {
            res += returnLCS(b, x, i - 1, j);
        } else if (b[i][j] == 3) {
            res += returnLCS(b, x, i, j - 1);
        }

        return res;
    }

    public static void main(String[] args) {
        BM65LCSubSequence p = new BM65LCSubSequence();
        String lcs = p.lcs("abc", "abcd");
        System.out.println(lcs);
    }
}
