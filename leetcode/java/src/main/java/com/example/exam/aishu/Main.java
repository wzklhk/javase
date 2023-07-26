package com.example.exam.aishu;

import java.util.Scanner;

/**
 * 和为0的子数组个数
 */

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        String[] split = s.split(",");

        int[] nums = new int[split.length];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        System.out.println(solve(nums));
    }

    public static int solve(int[] nums) {
        int n = nums.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                if (sum == 0) {
                    result++;
                }
            }
        }

        return result;
    }
}