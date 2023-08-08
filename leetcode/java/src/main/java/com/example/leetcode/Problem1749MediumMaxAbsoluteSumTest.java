package com.example.leetcode;

import org.junit.Test;

/**
 * @author wzklhk
 * <p>
 * 给你一个整数数组 nums 。一个子数组 [numsl, numsl+1, ..., numsr-1, numsr] 的 和的绝对值 为 abs(
 * numsl + numsl+1 + ... + numsr-1 + numsr) 。
 * <p>
 * 请你找出 nums 中 和的绝对值 最大的任意子数组（可能为空），并返回该 最大值 。
 * <p>
 * abs(x) 定义如下：
 * <p>
 * <p>
 * 如果 x 是负整数，那么 abs(x) = -x 。
 * 如果 x 是非负整数，那么 abs(x) = x 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,-3,2,3,-4]
 * 输出：5
 * 解释：子数组 [2,3] 和的绝对值最大，为 abs(2+3) = abs(5) = 5 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [2,-5,1,-4,3,-2]
 * 输出：8
 * 解释：子数组 [-5,1,-4] 和的绝对值最大，为 abs(-5+1-4) = abs(-8) = 8 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵
 * -10⁴ <= nums[i] <= 10⁴
 * <p>
 * <p>
 * Related Topics 数组 动态规划 👍 33 👎 0
 */

public class Problem1749MediumMaxAbsoluteSumTest {
    public int maxAbsoluteSumExhaustion(int[] nums) {
        int length = nums.length;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                max = Math.max(max, Math.abs(sum));
            }

        }
        return max;
    }

    public int maxAbsoluteSumDP(int[] nums) {
        int positiveMax = 0;
        int negativeMin = 0;
        int positiveSum = 0;
        int negativeSum = 0;
        for (int num : nums) {
            positiveSum += num;
            positiveMax = Math.max(positiveMax, positiveSum);
            positiveSum = Math.max(0, positiveSum);

            negativeSum += num;
            negativeMin = Math.min(negativeMin, negativeSum);
            negativeSum = Math.min(0, negativeSum);
        }
        return Math.max(positiveMax, -negativeMin);
    }

    public int maxAbsoluteSumDP2(int[] nums) {
        int pos = 0;
        int neg = 0;
        int ans = 0;
        for (int num : nums) {
            pos = pos > 0 ? pos + num : num;
            neg = neg < 0 ? neg + num : num;
            ans = Math.max(ans, Math.max(pos, -neg));
        }
        return ans;
    }

    @Test
    public void test() {
        int[] nums = {2, -5, 1, -4, 3, -2};
        int i = maxAbsoluteSumDP(nums);
        System.out.println(i);
    }
}
