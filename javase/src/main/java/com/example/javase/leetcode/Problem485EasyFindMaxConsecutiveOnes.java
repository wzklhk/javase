package com.example.javase.leetcode;

/**
 * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,1,0,1,1,1]
 * 输出：3
 * 解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入：nums = [1,0,1,1,0,1]
 * 输出：2
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵
 * nums[i] 不是 0 就是 1.
 * <p>
 * Related Topics 数组 👍 327 👎 0
 */


public class Problem485EasyFindMaxConsecutiveOnes {
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
        Problem485EasyFindMaxConsecutiveOnes p = new Problem485EasyFindMaxConsecutiveOnes();
        int[] nums = {1, 1, 0, 1, 1, 1, 1, 1, 1};
        System.out.println(p.findMaxConsecutiveOnes(nums));
    }

}
