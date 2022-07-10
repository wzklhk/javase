package com.example.javase.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PoolTest {
    public static void main(String[] args) {

        // 创建一个固定线程数（10）的线程池
        ExecutorService pool = Executors.newFixedThreadPool(10);

        Runnable target = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        };

        // 向线程池提供两个线程
        pool.submit(target);
        pool.submit(target);

        // 关闭线程池
        pool.shutdown();
    }
}
