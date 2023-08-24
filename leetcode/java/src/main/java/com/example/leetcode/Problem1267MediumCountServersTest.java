package com.example.leetcode;

import org.junit.Test;

import java.util.HashMap;

/**
 * @author wzklhk
 * <p>
 * 这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
 * <p>
 * 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
 * <p>
 * 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,0],[0,1]]
 * 输出：0
 * 解释：没有一台服务器能与其他服务器进行通信。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,0],[1,1]]
 * 输出：3
 * 解释：所有这些服务器都至少可以与一台别的服务器进行通信。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
 * 输出：4
 * 解释：第一行的两台服务器互相通信，第三列的两台服务器互相通信，但右下角的服务器无法与其他服务器通信。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 250
 * 1 <= n <= 250
 * grid[i][j] == 0 or 1
 * <p>
 * <p>
 * Related Topics 深度优先搜索 广度优先搜索 并查集 数组 计数 矩阵 👍 72 👎 0
 */

public class Problem1267MediumCountServersTest {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        HashMap<Integer, Integer> rowsCount = new HashMap<>();
        HashMap<Integer, Integer> colsCount = new HashMap<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowsCount.put(i, rowsCount.getOrDefault(i, 0) + 1);
                    colsCount.put(j, colsCount.getOrDefault(j, 0) + 1);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (rowsCount.get(i) > 1 || colsCount.get(j) > 1)) {
                    count++;
                }
            }
        }

        return count;
    }

    @Test
    public void test() {
        int[][] grid = {
                {1, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        int i = countServers(grid);
        System.out.println(i);
    }

    @Test
    public void test2() {
        int[][] grid = {
                {1, 0},
                {0, 1}
        };
        int i = countServers(grid);
        System.out.println(i);
    }
}
