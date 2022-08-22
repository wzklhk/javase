package com.example.javase.exam.netesae;

import java.util.Scanner;

public class Main2 {
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

        int n = nums.length;

        int maxNum1 = nums[0];
        int maxNum2 = nums[1];
        int maxNumIndex1 = 0;
        int maxNumIndex2 = 1;
        for (int i = 2; i < n; i++) {
            if (nums[i] > maxNum1) {
                maxNum2 = maxNum1;
                maxNumIndex2 = maxNumIndex1;
                maxNum1 = nums[i];
                maxNumIndex1 = i;
            } else if (nums[i] > maxNum2) {
                maxNum2 = nums[i];
                maxNumIndex2 = i;
            }
        }

        int wall1 = maxNum1;
        int wall2 = maxNum2;
        int result1 = 0;
        for (int i = maxNumIndex1 - 1; i >= 0; i--) {
            if ((maxNumIndex1 - i) % 2 == 1) {
                result1 += Math.abs(wall2 - nums[i]);
            } else {
                result1 += Math.abs(wall1 - nums[i]);
            }
        }
        for (int i = maxNumIndex1 + 1; i < n; i++) {
            if ((i - maxNumIndex1) % 2 == 1) {
                result1 += Math.abs(wall2 - nums[i]);
            } else {
                result1 += Math.abs(wall1 - nums[i]);
            }
        }

        int result2 = 0;
        for (int i = maxNumIndex2 - 1; i >= 0; i--) {
            if ((maxNumIndex2 - i) % 2 == 1) {
                result2 += Math.abs(wall1 - nums[i]);
            } else {
                result2 += Math.abs(wall2 - nums[i]);
            }
        }
        for (int i = maxNumIndex2 + 1; i < n; i++) {
            if ((i - maxNumIndex2) % 2 == 1) {
                result2 += Math.abs(wall1 - nums[i]);
            } else {
                result2 += Math.abs(wall2 - nums[i]);
            }
        }
        return Math.min(result1, result2);
    }
}
