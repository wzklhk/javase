package com.example.leetcode;

import org.junit.Test;

/**
 * @author wzklhk
 */
public class Problem980HardUniquePathIIITest {


    public int uniquePathsIII(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int si = 0;
        int sj = 0;
        int n = 0;  // 有多少个节点

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 0) {
                    n++;
                } else if (grid[i][j] == 1) {
                    n++;
                    si = i;
                    sj = j;
                }
            }
        }
        return dfs(grid, si, sj, n);
    }

    public int dfs(int[][] grid, int i, int j, int n) {
        if (grid[i][j] == 2) {
            return n == 0 ? 1 : 0;
        }
        int r = grid.length;
        int c = grid[0].length;
        int t = grid[i][j];
        grid[i][j] = -1;
        int res = 0;

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            if (ni >= 0 && ni < r && nj >= 0 && nj < c && (grid[ni][nj] == 0 || grid[ni][nj] == 2)) {
                res += dfs(grid, ni, nj, n - 1);
            }
        }
        grid[i][j] = t;
        return res;
    }

    @Test
    public void test() {
        int[][] grid = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        int i = uniquePathsIII(grid);
        System.out.println(i);
    }
}
