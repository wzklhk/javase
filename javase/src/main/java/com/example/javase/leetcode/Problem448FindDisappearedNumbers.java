package com.example.javase.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数
 * 字，并以数组的形式返回结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,1]
 * 输出：[2]
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
 * <p>
 * <p>
 * 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。
 * Related Topics 数组 哈希表 👍 1030 👎 0
 */


public class Problem448FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbersHashMap(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        // 存入map
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 查找map中缺少的数字
        for (int i = 1; i <= nums.length; i++) {
            if (map.getOrDefault(i, 0) == 0) {
                result.add(i);
            }
        }

        return result;
    }

    public List<Integer> findDisappearedNumbersNoHashMap(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        // 将数组元素对应为索引的位置加n
        // 存在问题：执行完以后nums的值会被改变
        for (int num : nums) {
            int x = (num - 1) % n;  // 找到当前数字顺序对应的位置
            nums[x] += n;  // 给相应数字位置上的数字加n
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem448FindDisappearedNumbers p = new Problem448FindDisappearedNumbers();
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(p.findDisappearedNumbersHashMap(nums));
    }
}
