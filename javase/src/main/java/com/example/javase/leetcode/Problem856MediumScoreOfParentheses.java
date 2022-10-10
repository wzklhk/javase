package com.example.javase.leetcode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/*
给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：


 () 得 1 分。
 AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 (A) 得 2 * A 分，其中 A 是平衡括号字符串。




 示例 1：

 输入： "()"
输出： 1


 示例 2：

 输入： "(())"
输出： 2


 示例 3：

 输入： "()()"
输出： 2


 示例 4：

 输入： "(()(()))"
输出： 6




 提示：


 S 是平衡括号字符串，且只含有 ( 和 ) 。
 2 <= S.length <= 50


 Related Topics 栈 字符串 👍 366 👎 0
*/


public class Problem856MediumScoreOfParentheses {

    /**
     * 分治法递归
     */
    public int scoreOfParentheses(String s) {
        int n = s.length();
        if (n == 2) {
            return 1;
        }

        int bal = 0;
        int len = 0;

        for (int i = 0; i < n; i++) {
            bal += (s.charAt(i) == '(' ? 1 : -1);
            if (bal == 0) {
                len = i + 1;
                break;
            }
        }

        if (len == n) {
            return 2 * scoreOfParentheses(s.substring(1, n - 1));
        } else {
            return scoreOfParentheses(s.substring(0, len)) + scoreOfParentheses(s.substring(len, n));
        }
    }

    /**
     * 栈
     */
    public int scoreOfParenthesesUsingStack(String s) {
        Deque<Integer> st = new ArrayDeque<>(); // 使用双端队列代替Stack，由于Stack继承Vector效率低。

        st.push(0);
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                st.push(0);
            } else {
                int v = st.pop();
                int top = st.pop() + Math.max(2 * v, 1);
                st.push(top);
            }
        }

        return st.peek();
    }

    /**
     * 计算最终分数和
     */
    public int scoreOfParenthesesCount(String s) {
        int bal = 0;
        int n = s.length();
        int result = 0;

        for (int i = 0; i < n; i++) {
            bal += (s.charAt(i) == '(' ? 1 : -1);
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
                result += 1 << bal;
            }
        }
        return result;
    }

    @Test
    public void test() {
        String s = "(()())";
        System.out.println(scoreOfParenthesesUsingStack(s));
    }
}
