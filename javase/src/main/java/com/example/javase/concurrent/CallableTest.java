package com.example.javase.concurrent;

import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) {
        FutureTask<Integer> task1 = new FutureTask<>(() -> {
            int i;
            for (i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);  // currentThread()返回当前正在执行的线程对象
                Thread.sleep(100);
            }
            return i;
        });
        FutureTask<Integer> task2 = new FutureTask<>(() -> {
            int i;
            for (i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);  // currentThread()返回当前正在执行的线程对象
                Thread.sleep(100);
            }
            return i;
        });


        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);  // currentThread()返回当前正在执行的线程对象
            if (i == 5) {
                new Thread(task1, "returned thread 1").start();
                /*try {
                    System.out.println("返回：" + task1.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }*/
                new Thread(task2, "returned thread 2").start();
                /*try {
                    System.out.println("返回：" + task2.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }*/

            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
