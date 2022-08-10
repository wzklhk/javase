package com.example.javase.newcoder.huawei;

import java.util.*;

public class RandomNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> set = new HashSet<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(sc.nextLine());
            set.add(num);
        }

        List<Integer> result = new ArrayList<>();
        result.addAll(set);
        Collections.sort(result);


        for (Integer r : result) {
            System.out.println(r);
        }
    }
}
