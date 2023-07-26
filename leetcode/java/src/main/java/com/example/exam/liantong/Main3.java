package com.example.exam.liantong;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int num = cin.nextInt();

        System.out.println(revertNum(num));
    }

    private static int revertNum(int num) {
        Integer a = num;
        String s = a.toString();
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            result *= 10;
            result += Integer.parseInt("" + s.charAt(i));
        }
        return result;
    }
}
