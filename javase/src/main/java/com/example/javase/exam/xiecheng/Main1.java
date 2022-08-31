package com.example.javase.exam.xiecheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println(solve2(in.nextLine()));
        }
    }

    private static int solve(int num) {
        if (num % 2 == 0) {
            return num;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 10; i >= 0; i--) {
            if (num / Math.pow(10, i) >= 1) {
                int p = (int) (num / Math.pow(10, i));
                list.add(p);
                num -= p * Math.pow(10, i);
            }
        }
        int flatNum = -1;
        for (Integer p : list) {
            if (p % 2 == 0) {
                flatNum = p;
                list.remove(p);
                break;
            }
        }
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            result += list.get(list.size() - 1 - i) * Math.pow(10, i + 1);
        }
        return flatNum == -1 ? -1 : result + flatNum;
    }

    private static int solve2(String num) {
        if (Integer.parseInt(num) % 2 == 0) {
            return Integer.parseInt(num);
        }
        int n = num.length();
        StringBuilder sb = new StringBuilder();
        Character flatNum = null;
        Integer flatNumIndex = null;
        for (int i = 0; i < n; i++) {
            if ((num.charAt(i) - '0') % 2 == 0) {
                flatNum = num.charAt(i);
                flatNumIndex = i;
            }
        }
        if (flatNum == null) {
            return -1;
        }
        for (int i = 0; i < n; i++) {
            if (i == flatNumIndex) {
                continue;
            }
            sb.append(num.charAt(i));
        }
        sb.append(flatNum);
        int result = Integer.parseInt(sb.toString());
        return result % 2 == 0 ? result : -1;
    }
}
