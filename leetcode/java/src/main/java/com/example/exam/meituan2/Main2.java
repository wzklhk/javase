package com.example.exam.meituan2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 81% Timeout
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        Integer[] nums = new Integer[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        Set<Integer> set = new HashSet<>();
        set.addAll(Arrays.asList(nums));

        for (Integer num : nums) {
            set.remove(num);
            System.out.print(mex(set) + " ");
            set.add(num);
        }
    }

    private static int mex(Set<Integer> set) {
        for (int i = 0; true; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
    }
}
