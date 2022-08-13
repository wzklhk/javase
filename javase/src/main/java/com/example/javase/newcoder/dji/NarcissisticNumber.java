package com.example.javase.newcoder.dji;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NarcissisticNumber {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            List<Integer> nums = count(n, m);
            if (nums.size() == 0) {
                System.out.println("no");
            } else {
                for (Integer num : nums) {
                    System.out.printf("%d ", num);
                }
                System.out.println();
            }

            in.nextLine();
        }
    }

    public static List<Integer> count(int m, int n) {
        List<Integer> result = new ArrayList<>();

        for (int i = m; i <= n; i++) {
            if (isNarcissisticNumber(i)) {
                result.add(i);
            }
        }
        return result;
    }

    public static boolean isNarcissisticNumber(int num) {
        int hundreds = num / 100;
        int tens = (num - hundreds * 100) / 10;
        int units = (num - hundreds * 100 - tens * 10);

        return hundreds * hundreds * hundreds + tens * tens * tens + units * units * units == num;
    }

}
