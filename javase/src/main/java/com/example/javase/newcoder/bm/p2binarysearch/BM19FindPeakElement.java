package com.example.javase.newcoder.bm.p2binarysearch;


/**
 * 给定一个长度为n的数组nums，请你找到峰值并返回其索引。数组可能包含多个峰值，在这种情况下，返回任何一个所在位置即可。
 * 1.峰值元素是指其值严格大于左右相邻值的元素。严格大于即不能有等于
 * 2.假设 nums[-1] = nums[n] = -\infty−∞
 * 3.对于所有有效的 i 都有 nums[i] != nums[i + 1]
 * 4.你可以使用O(logN)的时间复杂度实现此问题吗？
 * <p>
 * 数据范围：
 * 1 \le nums.length \le 2\times 10^5 \1≤nums.length≤2×10
 * 5
 * <p>
 * -2^{31}<= nums[i] <= 2^{31} - 1−2
 * 31
 * <=nums[i]<=2
 * 31
 * −1
 */
public class BM19FindPeakElement {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int findPeakElement(int[] nums) {
        int length = nums.length;
        for (int i = 1; i < length - 1; i++) {
            if (nums[i - 1] < nums[i] && nums[i + 1] < nums[i]) {
                return i;
            }
        }
        return 0;
    }

    /**
     * 找到最大的索引
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int findPeakElement2FindMaxIndex(int[] nums) {
        int length = nums.length;
        int index = 0;
        for (int i = 1; i < length; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }
        return index;
    }

    public int findPeakElementBinarySearch(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        return right;
    }
}
