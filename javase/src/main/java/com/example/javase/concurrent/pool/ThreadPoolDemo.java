package com.example.javase.concurrent.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {
    public static void main(String[] args) {

        // 创建一个固定线程数（10）的线程池
        ExecutorService pool1 = Executors.newFixedThreadPool(10);

        ExecutorService pool2 = Executors.newSingleThreadExecutor();

        ExecutorService pool3 = Executors.newCachedThreadPool();

        try {
            for (int i = 0; i < 10; i++) {
                pool1.execute(() -> {
                    System.out.println("1: " + Thread.currentThread().getName());
                });
            }
            for (int i = 0; i < 10; i++) {
                pool2.execute(() -> {
                    System.out.println("2: " + Thread.currentThread().getName());
                });
            }
            for (int i = 0; i < 200; i++) {
                pool3.execute(() -> {
                    System.out.println("3: " + Thread.currentThread().getName());
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭线程池
            pool1.shutdown();
            pool2.shutdown();
            pool3.shutdown();
        }
    }
}
