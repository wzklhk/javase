package com.example.javase.exam.huaweimianshi;

public class Main2 {

    public static void main(String[] args) {
        String i1 = "123456";
        String i2 = "123456";
        System.out.println(solve(i1, i2));
    }

    private static String solve(String i1, String i2) {
        int n1 = i1.length();
        int n2 = i2.length();

        String[] x = new String[n2];
        for (int i = n2 - 1; i >= 0; i--) {
            int c = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = n1 - 1; j >= 0; j--) {
                int r = (i2.charAt(i) - '0') * (i1.charAt(j) - '0') + c;
                int a = r % 10;
                c = (r - a) / 10;
                sb.append(a);
            }
            sb.reverse();
            for (int k = i + 1; k < n2; k++) {
                sb.append('0');
            }
            x[i] = sb.toString();
        }

        int c = 0;
        String result = "0";
        for (int i = 0; i < x.length; i++) {
            result = sum(result, x[i]);

        }
        return result;
    }

    private static String sum(String i1, String i2) {


        StringBuilder sbi1 = new StringBuilder(i1);
        sbi1.reverse();
        StringBuilder sbi2 = new StringBuilder(i2);
        sbi2.reverse();
        int n1 = sbi1.length();
        int n2 = sbi2.length();
        int n = Math.max(n1, n2);

        StringBuilder result = new StringBuilder();
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (i < n1 && i < n2) {
                int r = (sbi1.charAt(i) - '0') + (sbi2.charAt(i) - '0') + c;
                int a = r % 10;
                c = (r - a) / 10;
                result.append(a);
            } else if (i < n1 && i >= n2) {
                int r = (sbi1.charAt(i) - '0') + c;
                int a = r % 10;
                c = (r - a) / 10;
                result.append(a);
            } else if (i >= n1 && i < n2) {
                int r = (sbi2.charAt(i) - '0') + c;
                int a = r % 10;
                c = (r - a) / 10;
                result.append(a);
            }
        }
        return result.reverse().toString();
    }
}
