package com.example.leetcode;

import org.junit.Test;

/**
 * @author wzklhk
 * @date 2022/10/27 10:05
 * <p>
 * <p>
 * <p>
 * 已知函数 signFunc(x) 将会根据 x 的正负返回特定值：
 * <p>
 * <p>
 * 如果 x 是正数，返回 1 。
 * 如果 x 是负数，返回 -1 。
 * 如果 x 是等于 0 ，返回 0 。
 * <p>
 * <p>
 * 给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。
 * <p>
 * 返回 signFunc(product) 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [-1,-2,-3,-4,3,2,1]
 * 输出：1
 * 解释：数组中所有值的乘积是 144 ，且 signFunc(144) = 1
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,5,0,2,-3]
 * 输出：0
 * 解释：数组中所有值的乘积是 0 ，且 signFunc(0) = 0
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [-1,1,-1,1,-1]
 * 输出：-1
 * 解释：数组中所有值的乘积是 -1 ，且 signFunc(-1) = -1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 1000
 * -100 <= nums[i] <= 100
 * <p>
 * <p>
 * Related Topics 数组 数学 👍 55 👎 0
 */

public class Problem1822EasyArraySignTest {
    public int arraySign(int[] nums) {

        int product = sign(nums[0]);
        for (int i = 1; i < nums.length; i++) {

            product *= sign(nums[i]);
        }
        return Integer.compare(product, 0);
    }

    public int sign(int n) {
        return Integer.compare(n, 0);
    }

    public int arraySign2(int[] nums) {
        int sign = 1;

        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                sign = -sign;
            }
        }

        return sign;
    }

    @Test
    public void test() {
        int[] nums = {-1, -2, -3, -4, 3, 2, 1};
        System.out.println(arraySign(nums));
    }
}
