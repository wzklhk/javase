package com.example.exam.honor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] split = s.split(", ");
        int[] nums = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            nums[i] = Integer.parseInt(split[i]);
        }

        List<List<Integer>> solve = solve(nums);
        int m = solve.size();
        int n = solve.get(0).size();

        System.out.println("lenth:  " + n);

        for (int i = 0; i < m; i++) {
            System.out.printf("[");
            for (int j = 0; j < n; j++) {
                System.out.print(solve.get(i).get(j));
                if (j != n - 1) {
                    System.out.print(", ");
                }
            }
            System.out.printf("]\n");
        }


    }

    private static List<List<Integer>> solve(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;

        Arrays.sort(nums);

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        if (isDiffSeq(list)) {
            result.add(list);
            return result;
        }
//        if (length <= 2) {
//            List<Integer> tmp = new ArrayList<>();
//            for (int num : nums) {
//                tmp.add(num);
//            }
//            result.add(tmp);
//            return result;
//        }
//
//        int diff = nums[1] - nums[0];
//        boolean flag = true;
//        for (int i = 2; i < length; i++) {
//            if (nums[i] - nums[i - 1] != diff) {
//                flag = false;
//                break;
//            }
//        }
//
//
//        if (flag) {
//            List<Integer> tmp = new ArrayList<>();
//            for (int num : nums) {
//                tmp.add(num);
//            }
//            result.add(tmp);
//            return result;
//        }


        int left = 0;
        int right = 1;
        int diff2 = nums[right] - nums[left];
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(nums[left]);
        while (left < length && right < length) {
            if (nums[right] - nums[right - 1] == diff2) {
                tmp.add(nums[right]);
                right++;
            } else {
                result.add(tmp);
                tmp = new ArrayList<>();
                tmp.add(nums[right]);
                left = right;
                right++;
                diff2 = nums[right] - nums[left];
            }
            if (right == length) {
                result.add(tmp);
                break;
            }
        }

        return result;
    }

    private static List<List<Integer>> solve2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;

        Arrays.sort(nums);

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        if (isDiffSeq(list)) {
            result.add(list);
            return result;
        }

        int left = 0;
        int right = 1;
        int diff2 = nums[right] - nums[left];
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(nums[left]);
        while (left < length && right < length) {
            if (nums[right] - nums[right - 1] == diff2) {
                tmp.add(nums[right]);
                right++;
            } else {
                result.add(tmp);
                tmp = new ArrayList<>();
                tmp.add(nums[right]);
                left = right;
                right++;
                diff2 = nums[right] - nums[left];
            }
            if (right == length) {
                result.add(tmp);
                break;
            }
        }

        return result;
    }

    private static boolean isDiffSeq(List<Integer> list) {
        int size = list.size();
        if (size <= 2) {
            return true;
        }

        int diff = list.get(1) - list.get(0);
        for (int i = 2; i < size; i++) {
            if (list.get(i) - list.get(i - 1) != diff) {
                return false;
            }
        }
        return true;
    }
}
