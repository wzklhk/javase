package com.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 arr ，请你将数组中的每个元素替换为它们排序后的序号。
 * <p>
 * 序号代表了一个元素有多大。序号编号的规则如下：
 * <p>
 * <p>
 * 序号从 1 开始编号。
 * 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
 * 每个数字的序号都应该尽可能地小。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [40,10,20,30]
 * 输出：[4,1,2,3]
 * 解释：40 是最大的元素。 10 是最小的元素。 20 是第二小的数字。 30 是第三小的数字。
 * <p>
 * 示例 2：
 * <p>
 * 输入：arr = [100,100,100]
 * 输出：[1,1,1]
 * 解释：所有元素有相同的序号。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：arr = [37,12,28,9,100,56,80,5,12]
 * 输出：[5,3,4,2,8,6,7,1,3]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= arr.length <= 10⁵
 * -10⁹ <= arr[i] <= 10⁹
 * <p>
 * <p>
 * Related Topics 数组 哈希表 排序 👍 72 👎 0
 */

public class Problem1331EasyArrayRankTransform {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] sortedArray = Arrays.copyOf(arr, n);
        Arrays.sort(sortedArray);

        // 用于统计排序，key：arr的元素，value：arr出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : sortedArray) {
            if (!map.containsKey(i)) {
                map.put(i, map.size() + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            sortedArray[i] = map.get(arr[i]);
        }

        return sortedArray;
    }

    public static void main(String[] args) {
        Problem1331EasyArrayRankTransform p = new Problem1331EasyArrayRankTransform();
        int[] arr = {40, 10, 20, 30};
        int[] ints = p.arrayRankTransform(arr);

        for (int i : ints) {
            System.out.println(i);
        }
    }
}
