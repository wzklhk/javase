package com.example.javase.leetcode;

import java.util.Arrays;

/**
 * 给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：6
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：24
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [-1,-2,-3]
 * 输出：-6
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 3 <= nums.length <= 10⁴
 * -1000 <= nums[i] <= 1000
 * <p>
 * Related Topics 数组 数学 排序 👍 386 👎 0
 * <p>
 * <p>
 * 找到最大的正数三个数和最小的负数两个数
 */


public class Problem628EasyMaximumProduct {
    public int maximumProductSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);
    }

    public int maximumProductTraverse(int[] nums) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        return Math.max(min1 * min1 * max1, max1 * max2 * max3);
    }

    public static void main(String[] args) {
        Problem628EasyMaximumProduct p = new Problem628EasyMaximumProduct();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(p.maximumProductSort(nums));
    }
}
