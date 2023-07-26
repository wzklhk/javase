package com.example.leetcode;

/**
 * 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵
 * -2³¹ <= nums[i] <= 2³¹ - 1
 * 0 <= k <= 10⁵
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * <p>
 * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Related Topics 数组 数学 双指针 👍 1540 👎 0
 */


public class Problem189MediumRotate {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            int tmp = nums[n - 1];
            for (int j = n - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = tmp;
        }
    }

    public void rotateAdditionalArray(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            // result[i] = nums[(i - k) % n];  // Java负数取余是负数
            result[(i + k) % n] = nums[i];

        }
        System.arraycopy(result, 0, nums, 0, n);
    }

    public void rotateReverseArray(int[] nums, int k) {
        int n = nums.length;
        k %= nums.length;
        reverseArray(nums, 0, n - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, n - 1);
    }

    private void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int p, int q) {
        int tmp = nums[p];
        nums[p] = nums[q];
        nums[q] = tmp;
    }

    public static void main(String[] args) {
        Problem189MediumRotate p = new Problem189MediumRotate();
        int[] nums = {-1};
        int k = 1;
        p.rotateReverseArray(nums, k);

        for (int num : nums) {
            System.out.println(num);
        }
    }
}

