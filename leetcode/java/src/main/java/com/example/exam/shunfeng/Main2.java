package com.example.exam.shunfeng;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(solve(nums, m));
    }

    private static int solve(int[] nums, int m) {
        int n = nums.length;

        int result = 0;

        while (true) {
            int flag = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) {
                    flag++;
                }
            }
            if (flag < m) {
                break;
            }
            Arrays.sort(nums);
            int num = nums[n - m];
            result += num;
            for (int i = n - m; i < n; i++) {
                nums[i] -= num;
            }

        }
        return result;

    }
}

