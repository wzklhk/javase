package com.example.javase.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,2,0]
 * 输出：3
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 5 * 10⁵
 * -2³¹ <= nums[i] <= 2³¹ - 1
 * <p>
 * Related Topics 数组 哈希表 👍 1530 👎 0
 */


public class Problem41HardFirstMissingPositive {
    /**
     * 使用HashMap
     */
    public int firstMissingPositiveHashMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        // 存入map
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 1; i <= Integer.MAX_VALUE; i++) {
            Integer get = map.getOrDefault(i, 0);
            if (get == 0) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 空间复杂度O(n)，标记法
     */
    public int firstMissingPositiveNoHashMapMark(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }

    /**
     * 空间复杂度O(n)，置换法
     */
    public int firstMissingPositiveNoHashMapSwap(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        Problem41HardFirstMissingPositive p = new Problem41HardFirstMissingPositive();
        int[] nums = {5, 6, 7, 8};
        System.out.println(p.firstMissingPositiveNoHashMapMark(nums));
    }
}
