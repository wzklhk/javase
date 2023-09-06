package com.example.exam.guanglianfa;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wzklhk
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] s = new int[n];
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            s[i] = num;
        }

        int[] e = new int[n];
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            e[i] = num + s[i];
        }

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            a[i] = num;
        }

        System.out.println(jobScheduling(s, e, a));
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][];
        for (int i = 0; i < n; i++) {
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int k = binarySearch(jobs, i - 1, jobs[i - 1][0]);
            dp[i] = Math.max(dp[i - 1], dp[k] + jobs[i - 1][2]);
        }
        return dp[n];
    }

    public static int binarySearch(int[][] jobs, int right, int target) {
        int left = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid][1] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    @Test
    public void test() {


        int[] s = {1, 3, 6, 7, 11};
        int[] t = {4, 3, 4, 3, 9};
        int[] a = {2, 5, 5, 3, 4};
        int n = s.length;
        int[] e = new int[n];

        for (int i = 0; i < n; i++) {
            e[i] = s[i] + t[i];
        }
        int solve = jobScheduling(s, e, a);
        System.out.println(solve);
    }
}
