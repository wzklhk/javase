package com.example.javase.concurrent.collections;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * ArrayList线程不安全
 */
public class ThreadNotSafeList {
    public static void main(String[] args) {
        // ArrayList是线程不安全的
        // List<String> list = new ArrayList<>();

        // Vector是线程安全的
        // public synchronized boolean add(E e) {}
        // List<String> list = new Vector<>();

        // 利用Collections创建线程安全的List
        // List<String> list = Collections.synchronizedList(new ArrayList<>());

        // CopyOnWriteArrayList
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 30; i++) {
            // ConcurrentModificationException
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, "Thread" + (i + 1)).start();
        }
    }
}
