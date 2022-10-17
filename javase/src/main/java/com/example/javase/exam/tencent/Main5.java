package com.example.javase.exam.tencent;

import java.util.Scanner;


/**
 * 求x和y满足
 * <p>
 * |x| + |y| == sum(as)
 * <p>
 * bi = ai * x 或 bi = ai * y 使sum(bs) == 0;
 * <p>
 * <p>
 * ||x|-|y||最小
 */

public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        int[] xy = solve(nums);
        System.out.println(xy[0] + " " + xy[1]);
    }

    private static int[] solve(int[] as) {
        int[] result = new int[2];
        int n = as.length;

        int suma = 0;
        for (int i = 0; i < n; i++) {
            suma += as[i];
        }

        for (int x = suma / 2; x < suma; x++) {
            int y = -(suma - x);

            int sumb1 = 0;
            int sumb2 = 0;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    sumb1 += as[i] * x;
                } else {
                    sumb1 += as[i] * y;
                }
            }
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    sumb1 += as[i] * x;
                } else {
                    sumb1 += as[i] * y;
                }
            }
            if (sumb1 == 0) {
                result[0] = x;
                result[1] = y;
            }
        }


        return result;
    }
}
