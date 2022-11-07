package com.example.javase.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Problem1EasySumTest {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    @Test
    public void test() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] ans = twoSum(nums, target);

        System.out.println(ans[0]);
        System.out.println(ans[1]);


    }

}
