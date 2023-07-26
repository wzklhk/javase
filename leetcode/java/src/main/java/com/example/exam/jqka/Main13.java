package com.example.exam.jqka;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main13 {
    public int solve(int[] nums) {
        int n2 = nums.length;
        int n = n2 / 2;
        Arrays.sort(nums);

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += nums[i];
        }

        return result;
    }

    public String filter(List<String> list) {
        /*for (String str : list) {
            if ("null".equals(str)) {
                list.remove(str);
            }
        }
*/
        for (int i = 0; i < list.size(); i++) {
            if ("null".equals(list.get(i))) {
                list.remove(list.get(i));
            }
        }
        return list.get(0);
    }


    public static void main(String[] args) {
        Main13 p = new Main13();

        List<String> list = new ArrayList<>();

        list.add("null");
        list.add("ths");
        list.add("null");

        System.out.println(p.filter(list));
    }
}
