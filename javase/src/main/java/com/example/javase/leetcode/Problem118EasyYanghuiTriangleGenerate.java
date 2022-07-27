package com.example.javase.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数numRows，生成「杨辉三角」的前numRows行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例1:
 * <p>
 * <p>
 * 输入:numRows=5
 * 输出:[[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * <p>
 * <p>
 * 示例2:
 * <p>
 * <p>
 * 输入:numRows=1
 * 输出:[[1]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1<=numRows<=30
 * <p>
 * <p>
 * RelatedTopics数组动态规划👍794👎0
 */

public class Problem118EasyYanghuiTriangleGenerate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(ret.get(i - 1).get(j - 1) + ret.get(i - 1).get(j));
                }
            }
            ret.add(row);
        }
        return ret;
    }

    public static void main(String[] args) {

    }
}
