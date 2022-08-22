package com.example.javase.exam.zte;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String sIn = in.nextLine();
        String[] split = sIn.split(" ");
        String s1 = split[0];
        String s2 = split[1];
        String solve = solve(s1, s2);
        System.out.println(solve);
    }

    public static String solve(String s1, String s2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        for (char c = 'a'; c <= 'z'; c++) {
            Integer cm1 = map1.getOrDefault(c, 0);
            Integer cm2 = map2.getOrDefault(c, 0);
            if (!cm1.equals(cm2)) {
                return "" + c;
            }
        }
        return "";
    }
}
