package com.example.exam.meituan2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 82% Timeout
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        int[] q1 = new int[n];
        for (int i = 0; i < n; i++) {
            q1[i] = in.nextInt();
        }
        in.nextLine();

        int[] q2 = new int[n];
        for (int i = 0; i < n; i++) {
            q2[i] = in.nextInt();
        }
        in.nextLine();

        int[] q3 = new int[n];
        for (int i = 0; i < n; i++) {
            q3[i] = in.nextInt();
        }
        in.nextLine();

        System.out.println(solve(q1, q2, q3));
    }

    private static int solve(int[] q1, int[] q2, int[] q3) {
        int n = q1.length;
        Arrays.sort(q1);
        Arrays.sort(q2);
        Arrays.sort(q3);

        int result = 0;
        for (int i = 0; i < n; i++) {
            int h1 = q1[i];
            for (int j = 0; j < n; j++) {
                int h2 = q2[j];
                if (h1 < h2 && h2 <= 2 * h1) {
                    for (int k = 0; k < n; k++) {
                        int h3 = q3[k];
                        if (h2 < h3 && h3 <= 2 * h2) {
                            result++;
                        }
                    }
                }
            }
        }


        return result;
    }
}
