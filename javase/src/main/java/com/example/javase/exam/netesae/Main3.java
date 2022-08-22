package com.example.javase.exam.netesae;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(solve(s));
    }

    private static int solve(String s) {
        int n = s.length();

        int[][] map = new int[n][3];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'e') {
                map[i][0] = 1;
            }
            if (i - 1 >= 0 && i + 1 <= n - 1) {
                if (s.charAt(i - 1) == 'r' || s.charAt(i + 1) == 'r') {
                    map[i][1]++;
                }
                if (s.charAt(i - 1) == 'd' || s.charAt(i + 1) == 'd') {
                    map[i][2]++;
                }
            }
        }
        int result = 0;

        for (int i = 0; i < n; i++) {
            if (map[i][0] == 1) {
                if (!(map[i][1] == 0 && map[i][2] == 0) && !(map[i][1] == 1 && map[i][2] == 1)) {
                    result++;
                }
            }
        }

        return result;
    }
}
