package com.example.javase.newcoder.bm.p7dp;

/**
 * 一个机器人在m×n大小的地图的左上角（起点）。
 * 机器人每次可以向下或向右移动。机器人要到达地图的右下角（终点）。
 * 可以有多少种不同的路径从起点走到终点？
 */
public class BM67UniquePaths {
    public int uniquePathsMathPC(int m, int n) {
        long ret = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            //组合公式的循环求解
            ret = ret * x / y;
        }
        return (int) ret;
    }
}


