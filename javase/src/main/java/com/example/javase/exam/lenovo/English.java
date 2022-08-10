package com.example.javase.exam.lenovo;

import java.util.*;

public class English {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();

            String[] s1 = s.split(" ");
            words.addAll(Arrays.asList(s1));
        }

        Collections.sort(words);

        StringBuilder out = new StringBuilder();
        for (String word : words) {
            if (out.length() + word.length() < 10) {
                out.append(word);
                out.append(" ");
            } else {
                System.out.println(out);
                out = new StringBuilder();
            }
        }
        System.out.println(out);
    }
}
