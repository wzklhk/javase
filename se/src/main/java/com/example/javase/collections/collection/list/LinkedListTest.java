package com.example.javase.collections.collection.list;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListTest {
    public static void main(String[] args) {
        List<Integer> l = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            l.add(i);
        }

        ListIterator<Integer> iterator = l.listIterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next.equals(7)) {
                System.out.println(next);
            }
        }
    }
}
