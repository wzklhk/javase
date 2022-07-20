package com.example.javase.concurrent.collections;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * HashSet 线程不安全
 */
public class ThreadNotSafeSet {
    public static void main(String[] args) {
        // CopyOnWriteArraySet
        Set<String> set = new CopyOnWriteArraySet<>();

        for (int i = 0; i < 30; i++) {
            // ConcurrentModificationException
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            }, "Thread" + (i + 1)).start();
        }
    }
}
