package com.example.exam.tencent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        in.nextLine();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        System.out.println(solve(nums, k));
    }

    private static int solve(int[] nums, int k) {
        Integer n = nums.length;
        List<Integer> diffs = new ArrayList<>();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int num = nums[i];
            while (num > 1) {
                int diff = num - hasOneInBin(num);
                diffs.add(diff);
                num = hasOneInBin(num);
            }

        }
        Collections.sort(diffs);

        for (int i = 0; i < k && i < diffs.size(); i++) {
            sum -= diffs.get(diffs.size() - 1 - i);
        }
        return sum;
    }

    private static int hasOneInBin(int n) {
        String s = Integer.toBinaryString(n);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                result++;
            }
        }
        return result;
    }

}
