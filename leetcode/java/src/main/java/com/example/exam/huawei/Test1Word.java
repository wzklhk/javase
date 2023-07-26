package com.example.exam.huawei;

import java.util.Scanner;

public class Test1Word {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.printf("%.2f", solve(s));
    }

    private static double solve(String str) {
        String[] split = str.split(" ");
        int lengthSum = 0;
        for (String s : split) {
            lengthSum += s.length();
        }
        return (double) lengthSum / split.length;
    }
}
