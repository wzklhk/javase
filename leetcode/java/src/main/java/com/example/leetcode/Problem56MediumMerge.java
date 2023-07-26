package com.example.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author wzklhk
 * <p>
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
 * 回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= intervals.length <= 10⁴
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 10⁴
 * <p>
 * <p>
 * Related Topics 数组 排序 👍 1955 👎 0
 */


public class Problem56MediumMerge {
    public int[][] merge(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < intervals.length; i++) {
            int l = intervals[i][0];
            int r = intervals[i][1];

            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < l) {
                merged.add(new int[]{l, r});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(r, merged.get(merged.size() - 1)[1]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    @Test
    public void test() {
        Problem56MediumMerge p = new Problem56MediumMerge();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merged = p.merge(intervals);
        for (int i = 0; i < merged.length; i++) {
            System.out.println(merged[i][0] + " " + merged[i][1]);
        }
    }
}
