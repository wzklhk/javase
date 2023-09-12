package com.example.leetcode;

import org.junit.Test;

/**
 * @author wzklhk
 * <p>
 * 给你两个正整数 n 和 k，二进制字符串 Sn 的形成规则如下：
 * <p>
 * <p>
 * S1 = "0"
 * 当 i > 1 时，Si = Si-1 + "1" + reverse(invert(Si-1))
 * <p>
 * <p>
 * 其中 + 表示串联操作，reverse(x) 返回反转 x 后得到的字符串，而 invert(x) 则会翻转 x 中的每一位（0 变为 1，而 1 变为
 * 0）。
 * <p>
 * 例如，符合上述描述的序列的前 4 个字符串依次是：
 * <p>
 * <p>
 * S1 = "0"
 * S2 = "011"
 * S3 = "0111001"
 * S4 = "011100110110001"
 * <p>
 * <p>
 * 请你返回 Sn 的 第 k 位字符 ，题目数据保证 k 一定在 Sn 长度范围以内。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3, k = 1
 * 输出："0"
 * 解释：S3 为 "0111001"，其第 1 位为 "0" 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 4, k = 11
 * 输出："1"
 * 解释：S4 为 "011100110110001"，其第 11 位为 "1" 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：n = 1, k = 1
 * 输出："0"
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：n = 2, k = 3
 * 输出："1"
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 20
 * 1 <= k <= 2ⁿ - 1
 * <p>
 * <p>
 * Related Topics 递归 字符串 👍 57 👎 0
 */

public class Problem1547MediumFindKthBitTest {
    public char findKthBit(int n, int k) {
        String s = "0";
        while (s.length() < k) {
            s = s + "1" + reverse(invert(s));
        }
        return s.charAt(k - 1);
    }

    private String reverse(String s) {
        return new StringBuilder().append(s).reverse().toString();
    }

    private String invert(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(invert(s.charAt(i)));
        }
        return sb.toString();
    }

    private char invert(char c) {
        return c == '0' ? '1' : '0';
    }

    public char findKthBitRecursion(int n, int k) {
        if (k == 1) {
            return '0';
        }
        int mid = 1 << n - 1;  // 2^(n-1)
        if (k == mid) {  // 刚好是中间
            return '1';
        } else if (k < mid) {  // 前半部分
            return findKthBitRecursion(n - 1, k);
        } else {  // 后半部分
            k = mid * 2 - k;
            return invert(findKthBitRecursion(n - 1, k));
        }
    }


    @Test
    public void test() {
        int n = 4;
        int k = 11;
        System.out.println(findKthBit(n, k));
    }
}
