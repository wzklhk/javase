package com.example.leetcode;

import org.junit.Test;

/**
 * @author wzklhk
 * <p>
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * <p>
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = ["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 10⁵
 * s[i] 都是 ASCII 码表中的可打印字符
 * <p>
 * <p>
 * Related Topics 双指针 字符串 👍 793 👎 0
 */

public class Problem344EasyReverseStringTest {
    public void reverseString(char[] s) {
        int length = s.length;
        for (int i = 0; i < length / 2; i++) {
            char tmp = s[i];
            s[i] = s[length - 1 - i];
            s[length - 1 - i] = tmp;
        }
    }

    public void reverseString2(char[] s) {
        int length = s.length;
        int i = 0;
        int j = length - 1;
        while (i < j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;

            i++;
            j--;
        }
    }

    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    @Test
    public void test() {
        String s = "hello";
        char[] c = s.toCharArray();

        reverseString(c);

        for (char i : c) {
            System.out.println(i);
        }
    }

    @Test
    public void test2() {
        String s = "hello";

        System.out.println(reverseString(s));

    }
}
