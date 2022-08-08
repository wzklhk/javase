package com.example.javase.leetcode;

import java.util.Scanner;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 2 * 10⁵
 * 字符串 s 由 ASCII 字符组成
 * <p>
 * <p>
 * Related Topics 双指针 字符串 👍 556 👎 0
 */


public class Problem125EasyIsPalindrome {
    public boolean isPalindrome(String s) {
        int length = s.length();
        int start = 0;
        int end = length - 1;

        while (start < end) {
            while (start < end && !Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            while (start < end && !Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }

            if (Character.toUpperCase(s.charAt(start)) != Character.toUpperCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static void main(String[] args) {
        Problem125EasyIsPalindrome p = new Problem125EasyIsPalindrome();
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(p.isPalindrome(s));
        }

    }
}
