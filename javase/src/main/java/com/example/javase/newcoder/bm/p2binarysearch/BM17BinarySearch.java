package com.example.javase.newcoder.bm.p2binarysearch;

/**
 * 请实现无重复数字的升序数组的二分查找
 * <p>
 * 给定一个 元素升序的、无重复数字的整型数组 nums 和一个目标值 target ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标（下标从 0 开始），否则返回 -1
 * <p>
 * 数据范围：0 \le len(nums) \le 2\times10^50≤len(nums)≤2×10
 * 5
 * ， 数组中任意值满足 |val| \le 10^9∣val∣≤10
 * 9
 * <p>
 * 进阶：时间复杂度 O(\log n)O(logn) ，空间复杂度 O(1)O(1)
 */

public class BM17BinarySearch {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums   int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search(int[] nums, int target) {
        // write code here
        int length = nums.length;

        int left = 0;
        int right = length - 1;

        while (left <= right) {
            int position = (left + right) / 2;
            if (nums[position] == target) {
                return position;
            } else if (nums[position] > target) {
                right = position - 1;
            } else {
                left = position + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BM17BinarySearch p = new BM17BinarySearch();
        int[] nums = {-1, 0, 3, 4, 6, 10, 13, 14};
        int target = 13;
        int search = p.search(nums, target);
        System.out.println(search);
    }
}
