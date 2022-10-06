package com.example.javase.exam.jqka;

import java.util.ArrayList;
import java.util.List;

public class Main8 {
    public static void main(String[] args) {
        Main8 p = new Main8();
        System.out.println(p.solve(2));
    }

    public List<Integer> solve(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 64; i++) {
            list.add(i);
        }

        for (int i = 0; i < n; i++) {
            list = remove(list);
        }

        return list;
    }

    public List<Integer> remove(List<Integer> list) {
        int size = list.size();

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if ((i + 1) % 5 != 0) {
                result.add(list.get(i));
            }
        }
        return result;
    }

}
