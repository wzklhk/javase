package com.example.javase.concurrent.collections;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * HashMap 线程不安全
 */
public class ThreadNotSafeMap {
    public static void main(String[] args) {

        // ConcurrentHashMap
        Map<String, String> map = new ConcurrentHashMap<>();

        for (int i = 0; i < 30; i++) {
            // ConcurrentModificationException
            int finalI = i;
            new Thread(() -> {
                map.put("Thread" + (finalI + 1), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, "Thread" + (i + 1)).start();
        }
    }
}
