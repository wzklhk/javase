package com.example.javase.leetcode;

/**
 * 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：3
 * 解释：
 * 只需要3次操作（注意每次操作会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,1,1]
 * 输出：0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == nums.length
 * 1 <= nums.length <= 10⁵
 * -10⁹ <= nums[i] <= 10⁹
 * 答案保证符合 32-bit 整数
 * <p>
 * <p>
 * Related Topics 数组 数学 👍 470 👎 0
 */

public class Problem453EasyMinMoves {
    public int minMoves(int[] nums) {

        // 1、获取最小值
        // int minNum = Arrays.stream(nums).min().getAsInt();
        int minNum = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < minNum) {
                minNum = num;
            }
        }

        // 2、计算结果
        int res = 0;
        for (int num : nums) {
            res += num - minNum;
        }
        return res;
    }

    public static void main(String[] args) {
        Problem453EasyMinMoves p = new Problem453EasyMinMoves();

        int[] nums = {1, 1, 1000000000};
        System.out.println(p.minMoves(nums));
    }
}
