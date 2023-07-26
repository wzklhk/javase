package com.example.exam.xiecheng;

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
        int[] flatValue = flatValue(nums);
        if (flatValue[1] == 0) {
            nums[0] = nums[1];
        } else if (flatValue[2] == n - 1) {
            nums[n - 1] = nums[n - 2];
        } else if ((nums[flatValue[2] + 1] - nums[flatValue[2]]) < (nums[flatValue[1]] - nums[flatValue[1] - 1])) {
            int i = flatValue[2];
            nums[i] = (nums[i - 1] + nums[i + 1]) / 2;
        } else {
            int i = flatValue[1];
            nums[i] = (nums[i - 1] + nums[i + 1]) / 2;
        }
        flatValue = flatValue(nums);
        System.out.println(flatValue[0]);
    }

    private static int[] flatValue(int[] nums) {
        int n = nums.length;
        int[] result = new int[3];
        for (int i = 1; i < n; i++) {
            if (Math.abs(nums[i] - nums[i - 1]) >= result[0]) {
                result[0] = Math.abs(nums[i] - nums[i - 1]);
                result[1] = i - 1;
                result[2] = i;
            }
        }
        return result;
    }
}
