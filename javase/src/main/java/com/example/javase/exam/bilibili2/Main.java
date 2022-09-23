package com.example.javase.exam.bilibili2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        in.nextLine();

        char[] color = new char[n];
        String s = in.nextLine();
        for (int i = 0; i < n; i++) {
            color[i] = s.charAt(i);
        }

        System.out.println(solve(nums, color));


    }

    private static int solve(int[] nums, char[] color) {
        int n = nums.length;
        List<Integer> blue = new ArrayList<>();
        List<Integer> red = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (color[i] == 'B') {
                blue.add(nums[i]);
            } else if (color[i] == 'R') {
                red.add(nums[i]);
            }
        }
        Collections.sort(blue);
        Collections.sort(red);

        int bl = blue.get(0);
        int br = blue.get(blue.size() - 1);
        int rl = red.get(0);
        int rr = red.get(red.size() - 1);

        int result = Integer.MIN_VALUE;
        result = Math.max(result, bl * rl);
        result = Math.max(result, bl * rr);
        result = Math.max(result, br * rl);
        result = Math.max(result, br * rr);

        return result;
    }
}
