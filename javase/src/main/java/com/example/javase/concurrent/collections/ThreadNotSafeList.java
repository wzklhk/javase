package com.example.javase.concurrent.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * ArrayList线程不安全
 */
public class ThreadNotSafeList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, "Thread" + i + 1).start();
        }
    }
}
