package com.example.exam.baidu;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        Integer[] nums = new Integer[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        System.out.println(solve(nums));
    }

    private static int solve(Integer[] nums) {
        int result = 0;

        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            while (nums[i] >= 1 && nums[i + 1] >= 2 && nums[i + 2] >= 3) {
                result += 5;
                nums[i] -= 1;
                nums[i + 1] -= 2;
                nums[i + 2] -= 3;
            }
        }

        for (int i = 0; i < n; i++) {
            result += nums[i];
        }

        return result;
    }

    private static int solve2(Integer[] nums) {
        int result = 0;

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            result += nums[i];
        }

        return result;
    }
}
