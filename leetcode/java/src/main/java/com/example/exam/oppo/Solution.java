package com.example.exam.oppo;

import java.util.Arrays;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param digits int整型一维数组
     * @return int整型
     */
    public int maxDigit(int[] digits) {
        Arrays.sort(digits);
        int result = 0;
        for (int i = 0; i < digits.length; i++) {
            result += (int) (digits[i] * Math.pow(10, i));
        }
        return result;
    }
}