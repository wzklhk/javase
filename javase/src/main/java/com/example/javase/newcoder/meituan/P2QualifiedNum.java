package com.example.javase.newcoder.meituan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P2QualifiedNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int x = sc.nextInt();
        sc.nextLine();

        List<Integer> score = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int nextInt = sc.nextInt();
            score.add(nextInt);
        }

        int[] scoreArray = new int[n];
        for (int i = 0; i < score.size(); i++) {
            scoreArray[i] = score.get(i);
        }

        int i = qualifiedNum(scoreArray, x);

        System.out.println(i);

    }

    public static int qualifiedNum(int[] score, int x) {
        Arrays.sort(score);
        int length = score.length;
        int result = 0;
        int xScore = score[length - x];
        for (int i = length - 1; i >= 0; i--) {
            if (score[i] >= xScore && score[i] != 0) {
                result++;
            }
        }
        return result;
    }
}
