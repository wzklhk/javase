package com.example.leetcode;

/**
 * 假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则
 * 的情况下种入 n 朵花？能则返回 true ，不能则返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 1
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：flowerbed = [1,0,0,0,1], n = 2
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= flowerbed.length <= 2 * 10⁴
 * flowerbed[i] 为 0 或 1
 * flowerbed 中不存在相邻的两朵花
 * 0 <= n <= flowerbed.length
 * <p>
 * <p>
 * Related Topics 贪心 数组 👍 467 👎 0
 */


public class Problem605EasyCanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        if (flowerbed.length == 1) {
            return flowerbed[0] == 0;
        }

        for (int i = 0; i < flowerbed.length; i++) {
            if (i == 0) {
                if (flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            } else if (i == flowerbed.length - 1) {
                if (flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            } else {
                if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }

        }

        return n <= 0;
    }

    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int count = 0;  // 判断能种多少朵花
        int m = flowerbed.length;
        int prev = -1;  // 记录上一个能种花的位置

        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 1) {
                if (prev < 0) {
                    count += i / 2;
                } else {
                    count += (i - prev - 2) / 2;
                }
                prev = i;
            }
        }
        if (prev < 0) {
            count += (m + 1) / 2;
        } else
            count += (m - prev - 1) / 2;

        return count >= n;
    }

    public static void main(String[] args) {
        Problem605EasyCanPlaceFlowers p = new Problem605EasyCanPlaceFlowers();

        int[] flowerbed = {0, 1, 1, 0, 0, 1};
        int n = 1;
        System.out.println(p.canPlaceFlowers(flowerbed, n));
    }
}
