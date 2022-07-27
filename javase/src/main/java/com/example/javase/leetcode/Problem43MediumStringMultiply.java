package com.example.javase.leetcode;

public class Problem43MediumStringMultiply {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int n1 = num1.length();
        int n2 = num2.length();
        int[] ansArr = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n2 - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ansArr[i + j + 1] += x * y;
            }
        }
        for (int i = n1 + n2 - 1; i > 0; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] %= 10;
        }
        int index = ansArr[0] == 0 ? 1 : 0;
        StringBuffer ans = new StringBuffer();
        while (index < n1 + n2) {
            ans.append(ansArr[index]);
            index++;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String multiply = new Problem43MediumStringMultiply().multiply("2", "3");
        System.out.println(multiply);
    }
}
