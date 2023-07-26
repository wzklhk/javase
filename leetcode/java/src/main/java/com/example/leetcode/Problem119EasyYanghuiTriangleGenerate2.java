package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: rowIndex = 0
 * 输出: [1]
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: rowIndex = 1
 * 输出: [1,1]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 0 <= rowIndex <= 33
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？
 * <p>
 * Related Topics 数组 动态规划 👍 413 👎 0
 */


public class Problem119EasyYanghuiTriangleGenerate2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return row;
    }

    public static void main(String[] args) {
        Problem119EasyYanghuiTriangleGenerate2 p = new Problem119EasyYanghuiTriangleGenerate2();
        System.out.println(p.getRow(13));
    }
}
