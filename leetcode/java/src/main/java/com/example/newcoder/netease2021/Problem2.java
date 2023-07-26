package com.example.newcoder.netease2021;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Problem2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();

        int[] t = new int[m];
        for (int i = 0; i < m; i++) {
            t[i] = in.nextInt();
        }

        int[] solve = solve(n, t);

        for (int i = 0; i < solve.length; i++) {
            System.out.print(solve[i] + " ");
        }

    }

    public static int[] solve(int n, int[] t) {
        int tl = t.length;
        int[] result = new int[n];

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < tl; i++) {
            set.add(t[i]);
        }

        int j = 0;
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                result[i - 1] = i;
            } else {
                result[i - 1] = t[j];
                j++;
            }
        }

        return result;
    }
}
