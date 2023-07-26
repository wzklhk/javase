package com.example.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给你一个正整数组成的数组 nums ，返回 nums 中一个 升序 子数组的最大可能元素和。
 * <p>
 * 子数组是数组中的一个连续数字序列。
 * <p>
 * 已知子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，若对所有 i（l <= i < r），numsi <
 * numsi+1 都成立，则称这一子数组为 升序 子数组。注意，大小为 1 的子数组也视作 升序 子数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [10,20,30,5,10,50]
 * 输出：65
 * 解释：[5,10,50] 是元素和最大的升序子数组，最大元素和为 65 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [10,20,30,40,50]
 * 输出：150
 * 解释：[10,20,30,40,50] 是元素和最大的升序子数组，最大元素和为 150 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [12,17,15,13,10,11,12]
 * 输出：33
 * 解释：[10,11,12] 是元素和最大的升序子数组，最大元素和为 33 。
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：nums = [100,10,1]
 * 输出：100
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * <p>
 * <p>
 * Related Topics 数组 👍 70 👎 0
 */


public class Problem1800EasyMaxAscendingSum {

    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int result = nums[0];

        int sum = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) {
                sum = 0;
            }
            sum += nums[i];
            result = Math.max(sum, result);
        }
        return result;
    }

    /**
     * 动态规划法
     *
     * @param nums
     * @return
     */
    public int maxAscendingSumDP(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    /**
     * 简化动态规划，滚动数组实现
     *
     * @param nums
     * @return
     */
    public int maxAscendingSumDPArray(int[] nums) {
        int res = 0;
        int l = 0;
        while (l < nums.length) {
            int cursum = nums[l++];
            while (l < nums.length && nums[l] > nums[l - 1]) {
                cursum += nums[l++];
            }
            res = Math.max(res, cursum);
        }
        return res;
    }

    @Test
    public void test() {
        int[] nums = {12, 17, 15, 13, 10, 11, 12};
        System.out.println(maxAscendingSumDPArray(nums));
    }
}
