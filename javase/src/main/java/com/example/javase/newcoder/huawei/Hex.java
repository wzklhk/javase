package com.example.javase.newcoder.huawei;

import java.util.Scanner;

public class Hex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String in = sc.nextLine();

        int length = in.length();
        int result = 0;
        for (int i = length - 1; i >= 2; i--) {
            char c = in.charAt(i);
            int value = 0;
            int weight = (int) Math.pow(16, length - 1 - i);
            switch (c) {
                case '0':
                    value = 0;
                    break;
                case '1':
                    value = 1;
                    break;
                case '2':
                    value = 2;
                    break;
                case '3':
                    value = 3;
                    break;
                case '4':
                    value = 4;
                    break;
                case '5':
                    value = 5;
                    break;
                case '6':
                    value = 6;
                    break;
                case '7':
                    value = 7;
                    break;
                case '8':
                    value = 8;
                    break;
                case '9':
                    value = 9;
                    break;
                case 'A':
                    value = 10;
                    break;
                case 'B':
                    value = 11;
                    break;
                case 'C':
                    value = 12;
                    break;
                case 'D':
                    value = 13;
                    break;
                case 'E':
                    value = 14;
                    break;
                case 'F':
                    value = 15;
                    break;
                default:
                    break;
            }
            result += value * weight;
        }

        System.out.println(result);
    }
}
