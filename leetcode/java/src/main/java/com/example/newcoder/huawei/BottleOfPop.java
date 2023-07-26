package com.example.newcoder.huawei;

import java.util.Scanner;

public class BottleOfPop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = Integer.parseInt(sc.nextLine());
        while (num != 0) {
            System.out.println(bottle(num));
            num = Integer.parseInt(sc.nextLine());
        }

    }


    public static int bottle(int n) {
        int result = 0;
        while (n > 2) {
            result += n / 3;
            n = n / 3 + n % 3;
        }
        if (n == 2) {
            result++;
        }
        return result;
    }
}
