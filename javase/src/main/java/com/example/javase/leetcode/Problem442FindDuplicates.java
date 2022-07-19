package com.example.javase.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。请你找出所有出现 两次
 * 的整数，并以数组形式返回。
 * <p>
 * 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[2,3]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：[1]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [1]
 * 输出：[]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == nums.length
 * 1 <= n <= 10⁵
 * 1 <= nums[i] <= n
 * nums 中的每个元素出现 一次 或 两次
 * <p>
 * Related Topics 数组 哈希表 👍 637 👎 0
 */


public class Problem442FindDuplicates {
    /**
     * 利用哈希表
     */
    public List<Integer> findDuplicatesHashMap(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        // 存入map
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 查找map中重复的数字
        for (int i = 1; i <= nums.length; i++) {
            if (map.getOrDefault(i, 0) > 1) {
                result.add(i);
            }
        }

        return result;
    }

    /**
     * 原地修改
     */
    public List<Integer> findDuplicatesNoHashMap(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        // 将数组元素对应为索引的位置加n
        // 存在问题：执行完以后nums的值会被改变
        for (int num : nums) {
            int x = (num - 1) % n;  // 找到当前数字顺序对应的位置
            nums[x] += n;  // 给相应数字位置上的数字加n
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > n * 2) {
                result.add(i + 1);
            }
        }

        return result;
    }

    /**
     * 将元素交换到对应的位置
     */
    public List<Integer> findDuplicatesSwapLocation(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int n = nums.length;

        // 交换位置
        for (int i = 0; i < n; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < n; ++i) {
            if (nums[i] - 1 != i) {
                result.add(nums[i]);
            }
        }
        return result;
    }

    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }

    /**
     * 使用正负号作为标记
     */
    public List<Integer> findDuplicatesSigned(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] > 0) {
                nums[x - 1] = -nums[x - 1];
            } else {
                result.add(x);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Problem442FindDuplicates p = new Problem442FindDuplicates();
        int[] nums = {1};
        System.out.println(p.findDuplicatesSwapLocation(nums));
    }
}
