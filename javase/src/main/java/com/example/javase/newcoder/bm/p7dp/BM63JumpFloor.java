package com.example.javase.newcoder.bm.p7dp;

import java.util.Scanner;

public class BM63JumpFloor {


    public int jumpFloor(int target) {
        if (target <= 1) {
            return 1;
        }
        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }

    public int jumpFloorDP(int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BM63JumpFloor p = new BM63JumpFloor();
        int target = 7;
        System.out.println(p.jumpFloor(target));
    }
}
