//由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
//
//
// 如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I'
// 如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D'
//
//
// 给定一个字符串 s ，重构排列 perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。
//
//
//
// 示例 1：
//
//
//输入：s = "IDID"
//输出：[0,4,1,3,2]
//
//
// 示例 2：
//
//
//输入：s = "III"
//输出：[0,1,2,3]
//
//
// 示例 3：
//
//
//输入：s = "DDI"
//输出：[3,2,0,1]
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁵
// s 只包含字符 "I" 或 "D"
//
// Related Topics 贪心 数组 数学 双指针 字符串 👍 352 👎 0

package com.example.javase.leetcode;

public class Problem942EasyDiStringMatch {
    public static void main(String[] args) {
        Problem942EasyDiStringMatch solution = new Problem942EasyDiStringMatch();
        for (int d : solution.diStringMatch("DDD")) {
            System.out.println(d);
        }
    }

    /**
     * 贪心算法，数列不唯一，只返回其一。
     *
     * @param s 如果perm[i] < perm[i + 1]，那么s[i] == 'I'，
     *          如果perm[i] > perm[i + 1]，那么 s[i] == 'D'。
     * @return perm 重构排列
     */
    public int[] diStringMatch(String s) {
        int n = s.length();
        int lo = 0;
        int hi = n;

        int[] perm = new int[n + 1];

        for (int i = 0; i < n; i++) {
            perm[i] = s.charAt(i) == 'I' ? lo++ : hi--;
        }
        perm[n] = lo;  // perm[n] = hi;

        return perm;
    }
}
