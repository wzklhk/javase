package com.example.exam.meituan1;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();

        String s = in.nextLine();

        int[] mStringsLength = new int[m];
        for (int i = 0; i < m; i++) {
            mStringsLength[i] = in.nextInt();
        }
        in.nextLine();

        String[] mStrings = new String[m];
        for (int i = 0; i < m; i++) {
            mStrings[i] = in.nextLine();
        }

        System.out.println(solve(s, mStrings));
    }

    private static int solve(String s, String[] mStrings) {

        return 1;
    }
}
