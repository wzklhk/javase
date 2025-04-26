package com.example.javase.concurrent;

import lombok.SneakyThrows;

public class ThreadExtTest extends Thread {

    @SneakyThrows
    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);  // currentThread()返回当前正在执行的线程对象
            if (i == 5) {
                new ThreadExtTest().start();
                new ThreadExtTest().start();
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
