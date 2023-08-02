package com.example.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author wzklhk
 * <p>
 * 给你一个下标从 0 开始的整数数组 nums ，它表示英雄的能力值。如果我们选出一部分英雄，这组英雄的 力量 定义为：
 * <p>
 * <p>
 * i0 ，i1 ，... ik 表示这组英雄在数组中的下标。那么这组英雄的力量为 max(nums[i0],nums[i1] ... nums[ik])²
 * * min(nums[i0],nums[i1] ... nums[ik]) 。
 * <p>
 * <p>
 * 请你返回所有可能的 非空 英雄组的 力量 之和。由于答案可能非常大，请你将结果对 109 + 7 取余。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [2,1,4]
 * 输出：141
 * 解释：
 * 第 1 组：[2] 的力量为 2² * 2 = 8 。
 * <p>
 * 第 2 组：[1] 的力量为 1² * 1 = 1 。
 * <p>
 * 第 3 组：[4] 的力量为 4² * 4 = 64 。
 * <p>
 * 第 4 组：[2,1] 的力量为 2² * 1 = 4 。
 * <p>
 * 第 5 组：[2,4] 的力量为 4² * 2 = 32 。
 * <p>
 * 第 6 组：[1,4] 的力量为 4² * 1 = 16 。
 * <p>
 * 第​ ​​​​​​7 组：[2,1,4] 的力量为 4²​​​​​​​ * 1 = 16 。
 * <p>
 * 所有英雄组的力量之和为 8 + 1 + 64 + 4 + 32 + 16 + 16 = 141 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,1,1]
 * 输出：7
 * 解释：总共有 7 个英雄组，每一组的力量都是 1 。所以所有英雄组的力量之和为 7 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵
 * 1 <= nums[i] <= 10⁹
 * <p>
 * <p>
 * Related Topics 数组 数学 前缀和 排序 👍 121 👎 0
 */


public class Problem2681HardSumOfPowerTest {
    public int sumOfPowerDP1(int[] nums) {
        int mod = 1000000007;

        Arrays.sort(nums);

        int sum = 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int sumdp = 0;
            for (int j = 0; j <= i - 1; j++) {
                sumdp = (sumdp + dp[j]) % mod;
            }
            dp[i] = (nums[i] + sumdp) % mod;
            sum = (int) ((sum + ((long) nums[i] * nums[i]) % mod * dp[i]) % mod);
        }
        return sum;
    }

    public int sumOfPowerDP2(int[] nums) {
        int mod = 1000000007;

        Arrays.sort(nums);

        int sum = 0;
        int[] dp = new int[nums.length];
        int[] sumdp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = (nums[i] + sumdp[i]) % mod;
            sumdp[i + 1] = (sumdp[i] + dp[i]) % mod;
            sum = (int) ((sum + ((long) nums[i] * nums[i]) % mod * dp[i]) % mod);
        }
        return sum;
    }

    public int sumOfPowerDP3(int[] nums) {
        int mod = 1000000007;

        Arrays.sort(nums);

        int sum = 0;
        int dp = 0;
        int sumdp = 0;
        for (int i = 0; i < nums.length; i++) {
            dp = (nums[i] + sumdp) % mod;
            sumdp = (sumdp + dp) % mod;
            sum = (int) ((sum + ((long) nums[i] * nums[i]) % mod * dp) % mod);
        }
        return sum;
    }

    @Test
    public void test() {
        int[] nums = {2, 1, 4};
        int i = sumOfPowerDP1(nums);
        System.out.println(i);
    }
}
