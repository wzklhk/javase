package com.example.exam.meituan1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int t = in.nextInt();
        in.nextLine();

        int[] ts = new int[k];
        for (int i = 0; i < k; i++) {
            ts[i] = in.nextInt();
        }
        in.nextLine();

        int[] es = new int[n];
        for (int i = 0; i < n; i++) {
            es[i] = in.nextInt();
        }
        in.nextLine();

        System.out.println(solve(ts, es, t));

    }

    private static int solve(int[] ts, int[] es, int t) {
        Map<Integer, Integer> toyMap = new HashMap<>();
        int result = 0;
        for (int e : es) {
            if (e == 0) {
                if (isMapAll0(toyMap)) {
                    result += t;
                } else {
                    int minTime = Integer.MAX_VALUE;
                    int minTimeKey = 0;
                    for (Map.Entry<Integer, Integer> toy : toyMap.entrySet()) {
                        if (ts[toy.getKey() - 1] < minTime && toy.getValue() > 0) {
                            minTimeKey = toy.getKey();
                            minTime = ts[toy.getKey()];
                        }
                    }
                    result += ts[minTimeKey - 1];
                    toyMap.put(minTimeKey, toyMap.get(minTimeKey) - 1);
                }
            } else {
                toyMap.put(e, toyMap.getOrDefault(e, 0) + 1);
            }

        }
        return result;
    }

    private static boolean isMapAll0(Map<Integer, Integer> map) {

        if (map.isEmpty()) {
            return true;
        }
        boolean flag = true;
        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            if (i.getValue() > 0) {
                flag = false;
            }
        }
        return flag;
    }
}
