package com.example.exam.netesae;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int solve = solve(a, b);
        System.out.println(solve);
    }

    public static int solve(int a, int b) {
        if (a % b == 0 || b % a == 0) {
            return 0;
        }

        List<Integer> as = new ArrayList<>();
        List<Integer> bs = new ArrayList<>();
        for (int i = 9; i >= 0; i--) {
            if (a / Math.pow(10, i) < 1) {
                continue;
            } else if (a / Math.pow(10, i) >= 1) {
                as.add((int) (a / Math.pow(10, i)));
                a -= (int) (a / Math.pow(10, i)) * Math.pow(10, i);
            }
            if (b / Math.pow(10, i) < 1) {
                continue;
            } else if (b / Math.pow(10, i) >= 1) {
                bs.add((int) (b / Math.pow(10, i)));
                b -= (int) (b / Math.pow(10, i)) * Math.pow(10, i);
            }
        }


        List<Integer> al = new ArrayList<>();
        List<Integer> bl = new ArrayList<>();
        for (int i = as.size() - 1; i >= 0; i--) {

        }

        return -1;
    }
}
