package com.example.javase.exam.tencent;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            deque.addLast(in.nextInt());
        }

        List<Integer> solve = solve(deque);

        for (Integer i : solve) {
            System.out.print(i + " ");
        }
    }

    private static List<Integer> solve(Deque<Integer> deque) {
        int n = deque.size();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                if (deque.getFirst() > deque.getLast()) {
                    result.add(deque.removeFirst());
                } else {
                    result.add(deque.removeLast());
                }
            } else {
                if (deque.getFirst() < deque.getLast()) {
                    result.add(deque.removeFirst());
                } else {
                    result.add(deque.removeLast());
                }
            }
        }

        return result;
    }
}
