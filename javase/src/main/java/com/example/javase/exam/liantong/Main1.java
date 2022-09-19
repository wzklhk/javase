package com.example.javase.exam.liantong;

import java.util.HashMap;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String str = cin.nextLine();
        String[] split = str.split(" ");
        System.out.println(canBeSubstr(split[0], split[1]));
    }

    private static boolean canBeSubstr(String s1, String s2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s2.length(); i++) {
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        boolean result = true;

        for (Character c : map1.keySet()) {
            if (map1.get(c) > map2.getOrDefault(c, 0)) {
                return false;
            }
        }

        return result;
    }
}
