package com.example.javase.exam.oppo;


public class Solution3 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param scenicspot int整型
     * @return long长整型
     */
    public long tourismRoutePlanning(int scenicspot) {
        // write code here
        int[] dp = new int[scenicspot];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < scenicspot; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[scenicspot - 1];
    }

}