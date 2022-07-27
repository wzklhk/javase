package com.example.javase.leetcode;

import java.util.Arrays;

/**
 * 给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：[3, 2, 1]
 * 输出：1
 * 解释：第三大的数是 1 。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：[1, 2]
 * 输出：2
 * 解释：第三大的数不存在, 所以返回最大的数 2 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：[2, 2, 3, 1]
 * 输出：1
 * 解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
 * 此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁴
 * -2³¹ <= nums[i] <= 2³¹ - 1
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？
 * Related Topics 数组 排序 👍 370 👎 0
 */

public class Problem414EasyThirdMax {
    public int thirdMaxSort(int[] nums) {
        Arrays.sort(nums);
        /*for (int num : nums) {
            System.out.println(num);
        }*/
        int length = nums.length;
        if (length >= 3) {
            return nums[length - 3];
        } else {
            return nums[length - 1];
        }
    }

    public int thirdMaxTraverse(int[] nums) {
        long a = Long.MIN_VALUE, b = Long.MIN_VALUE, c = Long.MIN_VALUE;
        for (long num : nums) {
            if (num > a) {
                c = b;
                b = a;
                a = num;
            } else if (a > num && num > b) {
                c = b;
                b = num;
            } else if (b > num && num > c) {
                c = num;
            }
        }
        return c == Long.MIN_VALUE ? (int) a : (int) c;
    }

    public static void main(String[] args) {
        Problem414EasyThirdMax p = new Problem414EasyThirdMax();
        int[] nums = {2, 2, 3, 1};
        System.out.println(p.thirdMaxSort(nums));
    }
}
