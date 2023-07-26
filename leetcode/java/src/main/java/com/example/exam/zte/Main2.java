package com.example.exam.zte;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(",");
        int length = split.length;
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        Integer solve = solve(nums);
        System.out.println(solve);

    }

    public static Integer solve(int[] nums) {
        int length = nums.length;
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] >= 0) {
                result += (nums[i] - nums[i - 1]);
            }
        }

        return result;
    }
}
