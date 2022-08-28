package com.example.javase.exam.fenghuo;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        in.nextLine();

        int[] mySkillDamage = new int[n];
        for (int i = 0; i < n; i++) {
            mySkillDamage[i] = in.nextInt();
        }
        in.nextLine();

        int[] enemySkillDamage = new int[n];
        for (int i = 0; i < n; i++) {
            enemySkillDamage[i] = in.nextInt();
        }
        in.nextLine();

        int[] myDamageRate = new int[q];
        int[] enemyDamageRate = new int[q];
        for (int i = 0; i < q; i++) {
            myDamageRate[i] = in.nextInt();
            enemyDamageRate[i] = in.nextInt();
            in.nextLine();
        }

        int[] solve = solve(mySkillDamage, enemySkillDamage, myDamageRate, enemyDamageRate);

        for (int i : solve) {
            System.out.println(i);
        }

    }

    private static int[] solve(int[] mySkillDamage, int[] enemySkillDamage,
                               int[] myDamageRate, int[] enemyDamageRate) {
        int n = mySkillDamage.length;
        int p = myDamageRate.length;
        int[] result = new int[p];

        Arrays.sort(mySkillDamage);
        Arrays.sort(enemySkillDamage);

        for (int i = 0; i < p; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (mySkillDamage[n - 1 - j] * myDamageRate[i] > enemySkillDamage[j] * enemyDamageRate[i]) {
                    sum += mySkillDamage[n - 1 - j] * myDamageRate[i] - enemySkillDamage[j] * enemyDamageRate[i];
                } else {
                    break;
                }
            }
            result[i] = sum;
        }

        return result;
    }
}
