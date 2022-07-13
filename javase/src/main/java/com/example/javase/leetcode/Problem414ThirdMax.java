package com.example.javase.leetcode;

import java.util.Arrays;

public class Problem414ThirdMax {
    public int thirdMaxSort(int[] nums) {
        Arrays.sort(nums);
        /*for (int num : nums) {
            System.out.println(num);
        }*/
        int length = nums.length;
        if (length >= 3) {
            return nums[length - 3];
        } else {
            return nums[length - 1];
        }

    }

    public static void main(String[] args) {
        Problem414ThirdMax p = new Problem414ThirdMax();
        int[] nums = {2, 2, 3, 1};
        System.out.println(p.thirdMaxSort(nums));
    }
}
