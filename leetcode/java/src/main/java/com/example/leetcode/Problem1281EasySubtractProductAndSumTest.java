package com.example.leetcode;

import org.junit.Test;

/**
 * @author wzklhk
 * <p>
 * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 234
 * 输出：15
 * 解释：
 * 各位数之积 = 2 * 3 * 4 = 24
 * 各位数之和 = 2 + 3 + 4 = 9
 * 结果 = 24 - 9 = 15
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 4421
 * 输出：21
 * 解释：
 * 各位数之积 = 4 * 4 * 2 * 1 = 32
 * 各位数之和 = 4 + 4 + 2 + 1 = 11
 * 结果 = 32 - 11 = 21
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 10^5
 * <p>
 * <p>
 * Related Topics 数学 👍 138 👎 0
 */


public class Problem1281EasySubtractProductAndSumTest {
    public int subtractProductAndSum(int n) {
        int[] c = {100000, 10000, 1000, 100, 10, 1};
        int sum = 0;
        int product = 1;
        boolean isFoundFirst = false;
        for (int i = 0; i < c.length; i++) {
            int num = n / c[i];
            if (num >= 1) {
                if (!isFoundFirst) {
                    isFoundFirst = true;
                }
                n -= num * c[i];
            } else {
                num = 0;
            }
            if (isFoundFirst) {
                sum += num;
                product *= num;
            }

        }

        return product - sum;
    }

    public int subtractProductAndSum2(int n) {
        int product = 1;
        int sum = 0;
        while (n != 0) {
            int x = n % 10;
            n /= 10;

            product *= x;
            sum += x;
        }

        return product - sum;
    }

    public int subtractProductAndSumRecursion(int n) {
        return subtractProductAndSumRecursionHelper(n, 1, 0);
    }

    private int subtractProductAndSumRecursionHelper(int n, int product, int sum) {
        return n > 0 ? subtractProductAndSumRecursionHelper(n / 10, n % 10 * product, +n % 10 + sum) : product - sum;
    }

    @Test
    public void test() {
        int n = 705;
        int i = subtractProductAndSumRecursion(n);
        System.out.println(i);
    }

    @Test
    public void test2() {
        System.out.println(5 % 10);
    }
}
