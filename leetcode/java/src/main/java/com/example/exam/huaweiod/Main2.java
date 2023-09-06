package com.example.exam.huaweiod;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 给定字符串 target和 source, 判断 target 是否为 source 的子序列。
 * <p>
 * 你可以认为 target 和 source 中仅包含英文小写字母。字符串 source可能会很长（长度 ~= 500,000），而 target 是个短字符串（长度 <=100）。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"abc"是"aebycd"的一个子序列，而"ayb"不是）。
 * <p>
 * 请找出最后一个子序列的起始位置。
 * <p>
 * 输入描述:
 * <p>
 * 第一行为target，短字符串（长度 <=100）
 * <p>
 * 第二行为source，长字符串（长度 ~= 500,000）
 * <p>
 * 输出描述:
 * <p>
 * 最后一个子序列的起始位置， 即最后一个子序列首字母的下标
 * <p>
 * 示例1
 * <p>
 * 输入
 * <p>
 * abc
 * <p>
 * abcaybec
 * <p>
 * 输出
 * <p>
 * 3
 * <p>
 * 说明
 * <p>
 * 这里有两个abc的子序列满足，取下标较大的，故返回3
 * <p>
 * 备注:
 * <p>
 * 若在source中找不到target，则输出-1
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String target = in.nextLine();
        String source = in.nextLine();
        int solve = solve(target, source);
        System.out.println(solve);
    }

    public static int solve(String target, String source) {
        int tl = target.length();
        int sl = source.length();
        HashMap<Character, Integer> map = new HashMap<>();

        int dest = sl;
        if (tl > 0 && sl > 0) {
            for (int i = tl - 1; i >= 0; i--) {
                for (int j = sl - 1; j >= 0; j--) {
                    if (target.charAt(i) == source.charAt(j) && dest > j) {
                        dest = j;
                        map.put(target.charAt(i), j);
                        break;
                    }
                }
            }

            int ans = 0;
            for (int i = tl - 1; i >= 0; i--) {
                if (!map.containsKey(target.charAt(i))) {
                    ans = -1;
                    break;
                }
            }
            if (ans != -1) {
                return map.get(target.charAt(0));
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

}
