package com.example.exam.meituan1;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int b = in.nextInt();
        in.nextLine();

        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = in.nextInt();
        }
        in.nextLine();

        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = in.nextInt();
        }

        System.out.println(solve(b, p, t));
    }

    private static int solve(int b, int[] ps, int[] ts) {
        int n = ps.length;

        int pSum = 0;
        for (int p : ps) {
            pSum += p;
        }

        int pMax = ps[0];
        for (int p : ps) {
            if (p > pMax) {
                pMax = p;
            }
        }
        int pMin = ps[0];
        for (int p : ps) {
            if (p < pMin) {
                pMin = p;
            }
        }

        int tSum = 0;
        for (int t : ts) {
            tSum += t;
        }

        int tMax = ts[0];
        for (int t : ts) {
            if (t > tMax) {
                tMax = t;
            }
        }


        if (pSum <= b) {
            return tMax;
        } else if (ps[0] > b) {
            return -1;
        } else {
            int[] map = new int[n];
            map[0] = ts[0] * n;
            b -= ps[0];
            for (int i = 1; i < n; i++) {
                if (b > ps[i]) {
                    b -= ps[i];
                    map[i] = Math.max(ts[0] * i, ts[i] * n - i);
                } else {
                    map[i] = -1;
                }
            }
            int result = Integer.MAX_VALUE;
            for (int i : map) {
                if (i < result) {
                    result = i;
                }
            }
            return result;
        }

    }
}
