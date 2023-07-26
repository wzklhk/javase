package com.example.newcoder.meituan;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 某比赛已经进入了淘汰赛阶段,已知共有n名选手参与了此阶段比赛，他们的得分分别是a_1,a_2….a_n,小美作为比赛的裁判希望设定一个分数线m，使得所有分数大于m的选手晋级，其他人淘汰。
 * <p>
 * 但是为了保护粉丝脆弱的心脏，小美希望晋级和淘汰的人数均在[x,y]之间。
 * <p>
 * 显然这个m有可能是不存在的，也有可能存在多个m，如果不存在，请你输出-1，如果存在多个，请你输出符合条件的最低的分数线。
 * <p>
 * 数据范围：，
 * 进阶：时间复杂度，空间复杂度
 * <p>
 * input
 * <p>
 * 6 2 3
 * <p>
 * 1 2 3 4 5 6
 * <p>
 * output
 * <p>
 * 3
 */
public class Main1KnockoutMatch {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        in.nextLine();

        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = in.nextInt();
        }

        System.out.println(solve(x, y, scores));
    }

    private static int solve(int x, int y, int[] scores) {
        int n = scores.length;
        Arrays.sort(scores);

        if (2 * x > n || 2 * y < n) {
            return -1;
        }

        if (x + y >= n) {
            return scores[x - 1];
        } else {
            return scores[n - y - 1];
        }
    }
}
