package com.example.javase.algorithms.heap;

import java.util.PriorityQueue;

public class PriorQueueTest {

    public static void main(String[] args) {
        PriorityQueue<Integer> integers = new PriorityQueue<>();

        integers.add(2);
        integers.add(8);
        integers.add(7);
        integers.add(1);
        integers.add(3);
        integers.add(5);
        integers.add(6);
        integers.add(4);

        System.out.println(integers);
        int size = integers.size();
        for (int i = 0; i < size; i++) {
            System.out.println(integers.poll());
        }
    }
}
