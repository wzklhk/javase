package com.example.exam.netesae;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(solve(nums));
    }

    public static int solve(int[] nums) {
        int result = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] == nums[k] && nums[i] > nums[j]) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

}
