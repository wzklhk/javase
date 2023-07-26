package com.example.leetcode;

import java.util.Scanner;

/**
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * <p>
 * <p>
 * 全部字母都是大写，比如 "USA" 。
 * 单词中所有字母都不是大写，比如 "leetcode" 。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。
 * <p>
 * <p>
 * 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：word = "USA"
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：word = "FlaG"
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= word.length <= 100
 * word 由小写和大写英文字母组成
 * <p>
 * <p>
 * Related Topics 字符串 👍 209 👎 0
 */


public class Problem520EasyDetectCapitalUse {
    public boolean detectCapitalUse(String word) {
        // 若第 1 个字母为小写，则需额外判断第 2 个字母是否为小写
        if (word.length() >= 2 && Character.isLowerCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            return false;
        }

        // 无论第 1 个字母是否大写，其他字母必须与第 2 个字母的大小写相同
        for (int i = 2; i < word.length(); ++i) {
            if (Character.isLowerCase(word.charAt(i)) ^ Character.isLowerCase(word.charAt(1))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem520EasyDetectCapitalUse p = new Problem520EasyDetectCapitalUse();

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String word = sc.nextLine();
            System.out.println(p.detectCapitalUse(word));
        }
    }
}
