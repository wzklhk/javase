package com.example.javase.exam.honor;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.nextLine();
        String str = in.nextLine();
        int length = str.length();

        for (int i = 0; i < length; i += 9) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i + 9; j++) {
                sb.append(str.charAt(j));
            }
            System.out.print(solve(sb.toString()) + " ");
        }

    }

    private static String solve(String str) {
        int length = str.length();
        StringBuilder result = new StringBuilder();
        if (str.charAt(0) == '1') {
            for (int i = 1; i < length; i++) {
                result.append(str.charAt(i));
            }
        } else {
            for (int i = length - 1; i >= 1; i--) {
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }
}
