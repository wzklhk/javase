package com.example.leetcode;

import org.junit.Test;

/**
 * @author wzklhk
 * <p>
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果 needle 不是 haystack 的一部分，则返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= haystack.length, needle.length <= 10⁴
 * haystack 和 needle 仅由小写英文字符组成
 * <p>
 * <p>
 * Related Topics 双指针 字符串 字符串匹配 👍 1944 👎 0
 */

public class Problem28EasyStrStrTest {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i + m <= n; i++) {
            boolean isSame = true;
            for (int j = 0; j < m; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    isSame = false;
                    break;
                }
            }
            if (isSame) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        String haystack = "mississippi";
        String needle = "issipi";

        int i = strStr(haystack, needle);
        System.out.println(i);
    }

}
