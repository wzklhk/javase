package com.example.javase.mianshi.meituan;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 2, 6, 2, 5, 1};
        System.out.println(solve(nums, 0));
    }

    private static List<Integer> solve(int[] nums, int size) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();

        if (size == 0) {
            return list;
        }
        for (int i = 0; i < n - size + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + size; j++) {
                max = Math.max(max, nums[j]);
            }
            list.add(max);
        }
        return list;
    }

    private static List<Integer> solve2(int[] nums, int size) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();

        if (size == 0) {
            return list;
        }
        for (int i = 0; i < n - size + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + size; j++) {
                max = Math.max(max, nums[j]);
            }
            list.add(max);
        }
        return list;

    }
}
