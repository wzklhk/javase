package com.example.javase.exam.baidu;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(solve(str));
    }

    private static int solve(String str) {
        int n = str.length();
        int result = 0;

        for (int i = 0; i < n - 4; i++) {
            if (!isAEIOU(str.charAt(i)) && !isAEIOU(str.charAt(i + 3)) && isAEIOU(str.charAt(i + 1)) && isAEIOU(str.charAt(i + 2)) && isAEIOU(str.charAt(i + 4))) {
                Set<Character> set = new HashSet<>();
                set.add(str.charAt(i));
                set.add(str.charAt(i + 1));
                set.add(str.charAt(i + 2));
                set.add(str.charAt(i + 3));
                set.add(str.charAt(i + 4));
                if (set.size() == 5) {
                    result++;
                }
            }
        }

        return result;
    }

    private static boolean isAEIOU(Character c) {
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }
}
