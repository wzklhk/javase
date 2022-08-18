package com.example.javase.newcoder.bm.p2binarysearch;

/**
 * 在一个二维数组array中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * [
 * [1,2,8,9],
 * [2,4,9,12],
 * [4,7,10,13],
 * [6,8,11,15]
 * ]
 * 给定 target = 7，返回 true。
 * <p>
 * 给定 target = 3，返回 false。
 * <p>
 * 数据范围：矩阵的长宽满足 0 \le n,m \le 5000≤n,m≤500 ， 矩阵中的值满足 0 \le val \le 10^90≤val≤10
 * 9
 * <p>
 * 进阶：空间复杂度 O(1)O(1) ，时间复杂度 O(n+m)O(n+m)
 */

public class BM18BinarySearchTwoDimArray {

    /**
     * 穷举法：O(m * n)
     *
     * @param target int整型
     * @param array  int整型二维数组
     * @return boolean
     */
    public boolean find1(int target, int[][] array) {
        int m = array.length;
        int n = array[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param target int整型
     * @param array  int整型二维数组
     * @return boolean
     */
    public boolean find2(int target, int[][] array) {
        int m = array.length;
        int n = array[0].length;
        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = n - 1;
            while (left <= right) {
                int position = (left + right) / 2;
                if (target == array[i][position]) {
                    return true;
                } else if (target > array[i][position]) {
                    left = position + 1;
                } else {
                    right = position - 1;
                }
            }
        }
        return false;
    }

    /**
     * @param target int整型
     * @param array  int整型二维数组
     * @return boolean
     */
    public boolean find3(int target, int[][] array) {
        int m = array.length;
        int n = array[0].length;
        int i = m - 1;
        int j = 0;
        while (i >= 0 && j < n) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] < target) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        BM18BinarySearchTwoDimArray p = new BM18BinarySearchTwoDimArray();
        int target = 7;
        int[][] array = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };

        System.out.println(p.find2(target, array));
    }
}
