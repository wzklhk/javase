package com.example.javase.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数
 * 目来描述。
 * <p>
 * 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
 * 输出：[2,11,7,15]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
 * 输出：[24,32,8,12]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums1.length <= 10⁵
 * nums2.length == nums1.length
 * 0 <= nums1[i], nums2[i] <= 10⁹
 * <p>
 * <p>
 * Related Topics 贪心 数组 双指针 排序 👍 218 👎 0
 */


public class Problem870MediumAdvantageCount {
    /**
     * 贪心算法
     * <p>
     * 田忌赛马法
     * <p>
     * 排序
     * <p>
     * 小于的添加到前面
     * <p>
     * 大于的添加到后面
     */

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;

        Integer[] idx1 = new Integer[n];
        Integer[] idx2 = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx1[i] = i;
            idx2[i] = i;
        }

        Arrays.sort(idx1, (o1, o2) -> nums1[o1] - nums1[o2]);
        Arrays.sort(idx2, (o1, o2) -> nums2[o1] - nums2[o2]);

        int[] result = new int[n];

        int left = 0;
        int right = n - 1;

        for (int i = 0; i < n; i++) {
            if (nums1[idx1[i]] > nums2[idx2[left]]) {
                result[idx2[left]] = nums1[idx1[i]];
                left++;
            } else {
                result[idx2[right]] = nums1[idx1[i]];
                right--;
            }
        }

        return result;
    }

    @Test
    public void test() {
        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = {1, 10, 4, 11};
        int[] result = advantageCount(nums1, nums2);

        Arrays.stream(result).forEach(System.out::println);

    }
}
