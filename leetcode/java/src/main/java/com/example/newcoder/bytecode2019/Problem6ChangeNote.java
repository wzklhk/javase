package com.example.newcoder.bytecode2019;

import java.util.Scanner;

public class Problem6ChangeNote {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n > 1024 || n < 0) {
            return;
        }
        int coinNum = changeNote(n);

        System.out.println(coinNum);
    }

    public static int changeNote(int n) {
        int change = 1024 - n;

        int coinNum = 0;

        while (change > 0) {
            if (change >= 64) {
                change -= 64;
                coinNum++;
            } else if (change >= 16) {
                change -= 16;
                coinNum++;
            } else if (change >= 4) {
                change -= 4;
                coinNum++;
            } else {
                change -= 1;
                coinNum++;
            }
        }

        return coinNum;
    }
}
