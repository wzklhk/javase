package com.example.javase.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个包含大写字母和小写字母的字符串
 * s ，返回 通过这些字母构造成的 最长的回文串 。
 * <p>
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入:s = "abccccdd"
 * 输出:7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入:s = "a"
 * 输入:1
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入:s = "bb"
 * 输入: 2
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= s.length <= 2000
 * s 只能由小写和/或大写英文字母组成
 * <p>
 * <p>
 * Related Topics 贪心 哈希表 字符串 👍 439 👎 0
 */


public class Problem409LongestPalindrome {
    public int longestPalindrome(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int result = 0;
        for (char c = 'A'; c <= 'z'; c++) {
            Integer num = map.getOrDefault(c, 0);
            if (num % 2 == 0) {
                result += num;
            } else {
                result += num - 1;
                if (result % 2 == 0) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Problem409LongestPalindrome p = new Problem409LongestPalindrome();

        String s = "abccccdd";
        System.out.println(p.longestPalindrome(s));
    }
}
