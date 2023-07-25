package com.example.javase.leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wzklhk
 */
public class Problem179MediumLargestNumberTest {
    public String largestNumber(int[] nums) {

        Integer[] numsArr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsArr[i] = nums[i];
        }
        Arrays.sort(numsArr, new Comparator<Integer>() {

            @Override
            public int compare(Integer x, Integer y) {
                long sx = 10;
                long sy = 10;

                while (sx <= x) {
                    sx *= 10;
                }
                while (sy <= y) {
                    sy *= 10;
                }
                return (int) ((sx * y + x) - (sy * x + y));
            }
        });

        if (numsArr[0] == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (Integer num : numsArr) {
            sb.append(num);
        }

        return sb.toString();
    }

    @Test
    public void test() {
        int[] nums = {5, 19, 8, 1};
        String r = largestNumber(nums);
        System.out.println(r);
    }
}
