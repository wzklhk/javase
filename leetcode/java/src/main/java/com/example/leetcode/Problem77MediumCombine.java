package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 20
 * 1 <= k <= n
 * <p>
 * <p>
 * Related Topics 回溯 👍 1099 👎 0
 */


public class Problem77MediumCombine {
    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return ans;
    }

    /**
     * 回溯：使用深度优先搜索算法
     *
     * @param cur 当前位置
     * @param n   共n个
     * @param k   取k个
     */
    private void dfs(int cur, int n, int k) {
        // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        // 记录合法的答案
        if (temp.size() == k) {
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        // 考虑选择当前位置
        temp.add(cur);
        dfs(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        // 考虑不选择当前位置
        dfs(cur + 1, n, k);
    }

    public static void main(String[] args) {
        Problem77MediumCombine p = new Problem77MediumCombine();
        System.out.println(p.combine(4, 2));
    }
}
