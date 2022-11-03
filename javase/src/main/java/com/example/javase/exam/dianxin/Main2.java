package com.example.javase.exam.dianxin;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(",");
        int n = split.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }
        sort(nums);
    }

    private static void sort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int minValue = Integer.MAX_VALUE;
            int minIndex = 0;

            int j = 0;
            for (j = i; j < n; j++) {
                if (nums[j] < minValue) {
                    minValue = nums[j];
                    minIndex = j;
                }
            }

            int tmp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = tmp;

            System.out.print("第" + (i + 1) + "趟：");
            printArray(nums);
        }

    }

    private static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + ",");
        }
        System.out.println();
    }
}
