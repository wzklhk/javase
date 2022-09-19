package com.example.javase.exam.baidu;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int result = 0;
        int maxSpaceNums = 0;
        while (in.hasNext()) {
            String str = in.nextLine();
            int spaceNums = 0;
            for (int i = 0; i < str.length() - 2; i++) {
                if (str.charAt(i) == ' ') {
                    spaceNums++;
                } else if (str.charAt(i) == 'f' && str.charAt(i + 1) == 'o' && str.charAt(i + 2) == 'r') {
                    maxSpaceNums = Math.max(maxSpaceNums, spaceNums);
                }
            }
        }

        System.out.println((maxSpaceNums - 4) / 4);
    }
}
