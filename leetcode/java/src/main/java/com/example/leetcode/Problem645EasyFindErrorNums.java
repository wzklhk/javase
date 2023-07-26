package com.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有
 * 一个数字重复 。
 * <p>
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * <p>
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,1]
 * 输出：[1,2]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= nums.length <= 10⁴
 * 1 <= nums[i] <= 10⁴
 * <p>
 * Related Topics 位运算 数组 哈希表 排序 👍 273 👎 0
 */


public class Problem645EasyFindErrorNums {
    /**
     * 利用HashMap，找到出现2次和出现0次的数字，即为重复的数字和丢失的数字
     */
    public int[] findErrorNumsHashMap(int[] nums) {
        int[] errorNums = {0, 0};

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = 1; i <= nums.length; i++) {
            int count = map.getOrDefault(i, 0);
            if (count == 2) {
                errorNums[0] = i;
            } else if (count == 0) {
                errorNums[1] = i;
            }
        }
        return errorNums;
    }

    /**
     * 排序，
     */
    public int[] findErrorNumsSort(int[] nums) {
        int[] errorNums = new int[2];
        int n = nums.length;
        Arrays.sort(nums);
        int prev = 0;
        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            if (curr == prev) {
                errorNums[0] = prev;
            } else if (curr - prev > 1) {
                errorNums[1] = prev + 1;
            }
            prev = curr;
        }
        if (nums[n - 1] != n) {
            errorNums[1] = n;
        }
        return errorNums;
    }

    public static void main(String[] args) {
        Problem645EasyFindErrorNums p = new Problem645EasyFindErrorNums();
        int[] nums = {1, 1};
        int[] errorNumsSort = p.findErrorNumsSort(nums);
        for (int i : errorNumsSort) {
            System.out.println(i);
        }
    }
}
