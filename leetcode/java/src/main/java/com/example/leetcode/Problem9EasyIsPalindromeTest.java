package com.example.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author wzklhk
 * <p>
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * <p>
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 例如，121 是回文，而 123 不是。
 * 示例 1：
 * <p>
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 * <p>
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 提示：
 * <p>
 * -231 <= x <= 231 - 1
 * 进阶：你能不将整数转为字符串来解决这个问题吗？
 * <p>
 * Related Topics
 * 数学
 * <p>
 * 👍 2632
 * 👎 0
 */
public class Problem9EasyIsPalindromeTest {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        List<Integer> nums = new ArrayList<>();

        while (x > 0) {
            int r = x % 10;
            nums.add(r);
            x = x / 10;
        }

        int n = nums.size();
        for (int i = 0; i < n / 2; i++) {
            if (!Objects.equals(nums.get(i), nums.get(n - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) {
            return false;
        }
        int revertNum = 0;
        while (x > revertNum) {
            revertNum = revertNum * 10 + x % 10;
            x /= 10;
        }
        return x == revertNum || x == revertNum / 10;
    }

    public boolean isPalindromeToString(int x) {
        String string = Integer.toString(x);
        int n = string.length();
        for (int i = 0; i < n / 2; i++) {
            if (string.charAt(i) != string.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        int x = 1221;
        boolean isPalindrome = isPalindrome(x);
        System.out.println(isPalindrome);
    }
}
