package com.example.newcoder.meituan;


import java.util.Arrays;
import java.util.Scanner;

/**
 * 我们称一个长度为n的序列为正则序列，当且仅当该序列是一个由1~n组成的排列，即该序列由n个正整数组成，取值在[1,n]范围，且不存在重复的数，同时正则序列不要求排序
 * <p>
 * 有一天小团得到了一个长度为n的任意序列s，他需要在有限次操作内，将这个序列变成一个正则序列，每次操作他可以任选序列中的一个数字，并将该数字加一或者减一。
 * <p>
 * 请问他最少用多少次操作可以把这个序列变成正则序列？
 */
public class Main2RegSeq {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        System.out.println(solve(nums));
    }

    /**
     * 贪心法，排序然后给每个值进行修改，计算总修改次数。
     *
     * @param nums 要处理的序列
     * @return
     */
    private static int solve(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += Math.abs(i + 1 - nums[i]);
        }
        return result;
    }

}
