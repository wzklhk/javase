package com.example.javase.concurrent;

import lombok.SneakyThrows;

public class RunnableImplTest implements Runnable {

    @SneakyThrows
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);  // currentThread()返回当前正在执行的线程对象
            if (i == 5) {
                RunnableImplTest t = new RunnableImplTest();
                new Thread(t, "新线程1").start();
                new Thread(t, "新线程2").start();
            }
            Thread.sleep(1000);
        }
    }

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);  // currentThread()返回当前正在执行的线程对象
            Thread.sleep(1000);
        }
    }
}
