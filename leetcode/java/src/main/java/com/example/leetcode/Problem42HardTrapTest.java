package com.example.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * @author wzklhk
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == height.length
 * 1 <= n <= 2 * 10⁴
 * 0 <= height[i] <= 10⁵
 * <p>
 * <p>
 * Related Topics 栈 数组 双指针 动态规划 单调栈 👍 4508 👎 0
 */


public class Problem42HardTrapTest {
    public int trapWithRow(int[] height) {
        int sum = 0;
        int max = getMax(height);
        int length = height.length;

        for (int i = 1; i <= max; i++) {
            boolean isStart = false;
            int tempSum = 0;

            for (int j = 0; j < length; j++) {
                if (isStart && height[j] < i) {
                    tempSum++;
                }
                if (height[j] >= i) {
                    sum += tempSum;
                    tempSum = 0;
                    isStart = true;
                }
            }
        }
        return sum;
    }

    public int trapWithCol(int[] height) {
        int sum = 0;
        int l = height.length;

        for (int i = 1; i < l - 1; i++) {
            int maxLeft = 0;  // 最左边的墙
            int maxRight = 0;  // 最右边的墙

            // 找到最左边的墙
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > maxLeft) {
                    maxLeft = height[j];
                }
            }
            // 找到最左边的墙
            for (int j = i + 1; j < l; j++) {
                if (height[j] > maxRight) {
                    maxRight = height[j];
                }
            }

            int min = Math.min(maxLeft, maxRight);

            if (min > height[i]) {
                sum += min - height[i];
            }
        }

        return sum;
    }

    /**
     * @param height
     * @return
     */
    public int trapDP(int[] height) {
        int sum = 0;
        int l = height.length;

        // 优化寻找左边墙和右边墙的效率
        int[] maxLeft = new int[l];
        int[] maxRight = new int[l];

        for (int i = 1; i < l - 1; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }

        for (int i = l - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }

        for (int i = 1; i < l - 1; i++) {
            int min = Math.min(maxLeft[i], maxRight[i]);
            if (min > height[i]) {
                sum += min - height[i];
            }
        }

        return sum;
    }

    /**
     * 优化按列算，双指针
     *
     * @param height
     * @return
     */
    public int trapDoublePoint(int[] height) {
        int sum = 0;
        int l = height.length;

        int maxLeft = 0;
        int maxRight = 0;

        int left = 1;
        int right = l - 2;

        for (int i = 1; i < l - 1; i++) {
            // 判断左墙高还是右墙高
            if (height[left - 1] < height[right + 1]) {  // 从左到右更
                maxLeft = Math.max(maxLeft, height[left - 1]);
                int min = maxLeft;
                if (min > height[left]) {
                    sum += min - height[left];
                }
                left++;
            } else {  // 从左到右更
                maxRight = Math.max(maxRight, height[right + 1]);
                int min = maxRight;
                if (min > height[right]) {
                    sum += min - height[right];
                }
                right--;
            }
        }

        return sum;
    }

    /**
     * 通过栈解题，类似于括号匹配
     *
     * @param height
     * @return
     */
    public int trapStack(int[] height) {
        int sum = 0;
        int l = height.length;
        Stack<Integer> stack = new Stack<>();

        for (int current = 0; current < l; current++) {
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.peek()];
                stack.pop();
                if (stack.empty()) {
                    break;
                }
                int distance = current - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[current]);
                sum += distance * (min - h);
            }
            stack.push(current);
        }
        return sum;
    }

    public int getMax(int[] n) {
        int max = Integer.MIN_VALUE;
        for (int i : n) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    @Test
    public void test() {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int r = trapStack(height);
        System.out.println(r);
    }
}
