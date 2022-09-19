package com.example.javase.exam.threesixzero;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();

        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        in.nextLine();

        Integer[] t = new Integer[m];
        Integer[] x = new Integer[m];
        for (int i = 0; i < m; i++) {
            t[i] = in.nextInt();
            x[i] = in.nextInt();
            in.nextLine();
        }

        solve(a, t, x);

        for (int i : a) {
            System.out.print(i + " ");
        }
    }

    private static void solve(Integer[] a, Integer[] t, Integer[] x) {
        int n = a.length;
        int m = t.length;
        for (int i = 0; i < m; i++) {
            if (t[i] == 0) {
                Arrays.sort(a, 0, x[i]);
            } else {
                MyCmp cmp = new MyCmp();
                Arrays.sort(a, 0, x[i], cmp);
            }
        }
    }


}


class MyCmp implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}