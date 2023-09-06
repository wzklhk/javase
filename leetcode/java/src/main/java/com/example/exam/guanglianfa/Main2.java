package com.example.exam.guanglianfa;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author wzklhk
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve(a, 0, n - 1));
    }

    private static int solve(int[] a, int p, int q) {
        if (p == q) {
            return 0;
        } else if (p + 1 == q) {
            if (a[p] == a[q]) {
                return 0;
            } else {
                return 1;
            }
        }
        return solve(a, p, q / 2) + solve(a, q / 2 + 1, q);

    }

    @Test
    public void test() {
        int[] a = {1, 2, 3, 4};
        System.out.println(solve(a, 0, a.length - 1));
    }
}


