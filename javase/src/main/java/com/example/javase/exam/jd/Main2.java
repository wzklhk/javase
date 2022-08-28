package com.example.javase.exam.jd;

import java.util.HashMap;
import java.util.Map;
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

    private static int solve(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> oddMap = new HashMap<>();
        int oddCount = 0;
        for (int i = 1; i < n; i += 2) {
            oddMap.put(nums[i], oddMap.getOrDefault(nums[i], 0) + 1);
            oddCount++;
        }
        int oddCountMax = 0;
        for (Integer integer : oddMap.keySet()) {
            if (oddMap.get(integer) > oddCountMax) {
                oddCountMax = oddMap.get(integer);
            }
        }

        Map<Integer, Integer> flatMap = new HashMap<>();
        int flatCount = 0;
        for (int i = 0; i < n; i += 2) {
            flatMap.put(nums[i], flatMap.getOrDefault(nums[i], 0) + 1);
            flatCount++;
        }
        int flatCountMax = 0;
        for (Integer integer : flatMap.keySet()) {
            if (flatMap.get(integer) > flatCountMax) {
                flatCountMax = flatMap.get(integer);
            }
        }

        return (flatCount - flatCountMax) + (oddCount - oddCountMax);
    }
}
