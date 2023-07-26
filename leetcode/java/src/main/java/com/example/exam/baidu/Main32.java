package com.example.exam.baidu;

import java.util.Scanner;

public class Main32 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (in.hasNext()) {
            sb.append(in.nextLine());
            sb.append("\n");
        }
        System.out.println(solve(sb.toString()));
    }

    private static int solve(String str) {
        int result = 0;

        int length = str.length();
        int i = 0;
        while (i < length) {
            if (str.charAt(i) == '{') {
                int j = i;
                while (j >= 0) {
                    if (str.charAt(j) == ';' || str.charAt(j) == '}') {
                        String substring = str.substring(j + 1, i);
                        if (substring.indexOf("for") != -1) {
                            result++;
                        }
                        break;
                    }
                    j--;
                }
            }
            i++;
        }
        return result;
    }
}
