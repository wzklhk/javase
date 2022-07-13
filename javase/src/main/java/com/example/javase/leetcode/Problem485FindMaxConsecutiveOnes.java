package com.example.javase.leetcode;

public class Problem485FindMaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutiveOnes = 0;
        int current = 0;
        for (int num : nums) {
            if (num == 1) {
                current += 1;
                if (current > maxConsecutiveOnes) {
                    maxConsecutiveOnes = current;
                }
            } else {
                current = 0;
            }
        }
        return maxConsecutiveOnes;
    }

    public static void main(String[] args) {
        Problem485FindMaxConsecutiveOnes p = new Problem485FindMaxConsecutiveOnes();
        int[] nums = {1, 1, 0, 1, 1, 1, 1, 1, 1};
        System.out.println(p.findMaxConsecutiveOnes(nums));
    }

}
