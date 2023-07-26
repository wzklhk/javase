package com.example.leetcode;

/**
 * 索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到最大的集合S并返回其大小，其中 S[i] = {A[i], A[A[i]], A[A[A[
 * i]]], ... }且遵守以下的规则。
 * <p>
 * 假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元
 * 素。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: A = [5,4,0,3,1,6,2]
 * 输出: 4
 * 解释:
 * A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 * <p>
 * 其中一种最长的 S[K]:
 * S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵
 * 0 <= nums[i] < nums.length
 * A中不含有重复的元素。
 * <p>
 * <p>
 * Related Topics 深度优先搜索 数组 👍 292 👎 0
 */


public class Problem565MediumArrayNesting {
    public int arrayNesting(int[] nums) {
        int ans = 0;
        int n = nums.length;

        boolean[] vis = new boolean[n]; // 用vis[]数组来标记访问过的节点

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            while (!vis[i]) {
                vis[i] = true;
                i = nums[i];
                cnt++;
            }
            ans = Math.max(ans, cnt);
        }

        return ans;
    }

    public static void main(String[] args) {
        Problem565MediumArrayNesting p = new Problem565MediumArrayNesting();
        int[] nums = {5, 4, 0, 3, 1, 6, 2};
        int i = p.arrayNesting(nums);
        System.out.println(i);
    }
}
