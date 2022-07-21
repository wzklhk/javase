package com.example.javase.leetcode;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: nums = [0]
 * 输出: [0]
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁴
 * -2³¹ <= nums[i] <= 2³¹ - 1
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：你能尽量减少完成的操作次数吗？
 * <p>
 * Related Topics 数组 双指针 👍 1664 👎 0
 */


public class Problem283MoveZeroes {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, right, left);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public void moveZeroes2(int[] nums) {
        int left = 0;
        int right = 0;
        int n = nums.length;

        while (right < n) {
            if (nums[right] != 0) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        for (int i = left; i < n; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        Problem283MoveZeroes p = new Problem283MoveZeroes();
        int[] nums = {1, 0, 2, 3};
        p.moveZeroes2(nums);

        for (int num : nums) {
            System.out.println(num);
        }
    }
}
