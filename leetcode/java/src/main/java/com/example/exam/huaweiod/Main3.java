package com.example.exam.huaweiod;

import org.junit.Test;

import java.util.Scanner;

/**
 * 题目
 * 输入一串方波信号，求取最长的完全连续交替方波信号，并将其输出，如果有相同长度的交替方波信号，输出任一即可，方波信号高位用1标识，低位用0标识，如图：
 * <p>
 * 说明：
 * 1） 一个完整的信号一定以0开始然后以0结尾，即010是一个完整信号，但101，1010，0101不是
 * 2）输入的一串方波信号是由一个或多个完整信号组成
 * 3） 两个相邻信号之间可能有0个或多个低位，如0110010，011000010
 * 4） 同一个信号中可以有连续的高位，如01110101011110001010，前14位是一个具有连续高位的信号
 * 5） 完全连续交替方波是指10交替，如01010是完全连续交替方波，0110不是
 * <p>
 * 输入描述:
 * 输入信号字符串（长度>=3且<=1024）：
 * 0010101010110000101000010
 * 注：输入总是合法的，不用考虑异常情况
 * <p>
 * 输出描述:
 * 输出最长的完全连续交替方波信号串：
 * 01010
 * 若不存在完全连续交替方波信号串，输出 -1
 * <p>
 * 示例1
 * 输入
 * 00101010101100001010010
 * <p>
 * 输出
 * 01010
 * <p>
 * 备注:
 * 输入信号串中有三个信号：0 010101010110(第一个信号段) 00 01010(第二个信号段) 010(第三个信号段)
 * 第一个信号虽然有交替的方波信号段，但出现了11部分的连续高位，不算完全连续交替方波，在剩下的连续方波信号串中01010最长
 * <p>
 * 示例2
 * 输入
 * 00101010101000010100100
 * <p>
 * 输出
 * 01010101010
 */
public class Main3 {

    private static String result = "";
    private static int max = -1;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String signal = in.nextLine();

        String solve = solve(signal);
        System.out.println(solve);
    }

    private static String solve(String signal) {
        String[] split = signal.split("00");
        int length = split.length;
        if (length > 1) {
            for (String s : split) {
                if (s.equals("")) {
                    continue;
                }
                if (s.charAt(0) == '1') {
                    s = "0" + s;
                }
                if (s.charAt(s.length() - 1) == '1') {
                    s = s + "0";
                }
                check(s);
            }
        } else {
            check(signal);
        }
        if (max != -1) {
            return result;
        } else {
            return "-1";
        }
    }

    private static void check(String sign) {
        if (!sign.contains("11") && sign.contains("010")) {
            if (sign.matches("0(10)+")) {
                if (sign.length() > max) {
                    max = sign.length();
                    result = sign;
                }
            }
        }
    }

    @Test
    public void testMatches() {
        String s = "abcd";
        System.out.println(s.matches("[a-z]*ab[a-z]*"));

    }
}
