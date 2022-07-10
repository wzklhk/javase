package com.example.javase.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) {
        FutureTask<Integer> task = new FutureTask<>(() -> {
            int i;
            for (i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);  // currentThread()返回当前正在执行的线程对象
                Thread.sleep(1000);
            }
            return i;
        });

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);  // currentThread()返回当前正在执行的线程对象
            if (i == 5) {
                new Thread(task, "returned thread 1").start();
                try {
                    System.out.println("返回：" + task.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
                new Thread(task, "returned thread 2").start();

            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
