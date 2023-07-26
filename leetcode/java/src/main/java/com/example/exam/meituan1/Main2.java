package com.example.exam.meituan1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();

        int[] mNums = new int[m];
        for (int i = 0; i < m; i++) {
            mNums[i] = in.nextInt();
        }

        List<Integer> integers = solve2(n, mNums);
        for (int i : integers) {
            System.out.print(i + " ");
        }
    }

    private static int[] solve(int n, int[] mNums) {
        List<Integer> result = new ArrayList<>();

        int[] nNums = new int[n];

        for (int i = 0; i < n; i++) {
            nNums[i] = i + 1;
        }

        for (int mNum : mNums) {
            int tmp = nNums[mNum - 1];
            for (int i = mNum - 1; i > 0; i--) {
                nNums[i] = nNums[i - 1];
            }
            nNums[0] = tmp;
        }
        return nNums;
    }

    private static List<Integer> solve2(int n, int[] mNums) {
        List<Integer> result = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            result.add(i + 1);
        }

        for (int mNum : mNums) {
            Integer integer = result.get(mNum - 1);
            result.remove(mNum - 1);
            result.add(0, integer);

        }
        return result;
    }
}
