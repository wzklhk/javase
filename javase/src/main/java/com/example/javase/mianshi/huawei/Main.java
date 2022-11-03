package com.example.javase.mianshi.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {1, 2, 3, 3, 5};
        int[] nums3 = {1, 2, 3, 1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1};
        System.out.println(solve2(nums3, 6));
    }

    private static int solve1(int[] nums, int k) {
        int n = nums.length;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {

                sum += nums[j];
                if (sum == k) {
                    list.add(j - i + 1);
                }
            }
        }

        return Collections.max(list);
    }

    private static int solve2(int[] nums, int k) {
        int n = nums.length;
        int result = 0;


        int left = 0;
        int right = 1;

        int sum = nums[0] + nums[1];
        while (left < n && right < n) {
            if (sum < k) {
                right++;
                if (right != n) {
                    sum += nums[right];
                }
            } else if (sum == k) {
                result = Math.max(result, right - left + 1);
                right++;
                if (right != n) {
                    sum += nums[right];
                }
            } else {
                sum -= nums[left];
                left++;
            }
        }
        return result;
    }
}