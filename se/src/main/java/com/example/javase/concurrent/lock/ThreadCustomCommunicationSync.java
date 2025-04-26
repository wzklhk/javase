package com.example.javase.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCustomCommunicationSync {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    sharedResource.print1(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "thread1").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    sharedResource.print2(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }, "thread2").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    sharedResource.print3(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "thread3").start();

    }
}

/**
 * 0或1，为0时可+1，为1时可-1
 */
class SharedResource {
    private int flag = 1; // 1为线程1，2为线程2，3为线程3

    private final Lock lock = new ReentrantLock();

    private final Condition c1 = lock.newCondition();
    private final Condition c2 = lock.newCondition();
    private final Condition c3 = lock.newCondition();

    /**
     * 打印5次操作
     *
     * @param loop 轮数
     * @throws InterruptedException
     */
    public void print1(int loop) throws InterruptedException {
        lock.lock();
        try {
            // 判断
            while (flag != 1) {
                c1.await();
            }
            // 工作
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\tloop\t" + loop);
            }
            // 通知
            flag = 2;
            c2.signal();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 打印10次操作
     *
     * @param loop 轮数
     * @throws InterruptedException
     */
    public void print2(int loop) throws InterruptedException {
        lock.lock();
        try {
            // 判断
            while (flag != 2) {
                c2.await();
            }
            // 工作
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\tloop\t" + loop);
            }
            // 通知
            flag = 3;
            c3.signal();
        } finally {
            lock.unlock();
        }
    }

    /**
     * 打印15次操作
     *
     * @param loop 轮数
     * @throws InterruptedException
     */
    public void print3(int loop) throws InterruptedException {
        lock.lock();
        try {
            // 判断
            while (flag != 3) {
                c3.await();
            }
            // 工作
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i + "\tloop\t" + loop);
            }
            // 通知
            flag = 1;
            c1.signal();
        } finally {
            lock.unlock();
        }
    }

}

