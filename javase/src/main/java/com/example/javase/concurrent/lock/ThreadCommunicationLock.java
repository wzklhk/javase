package com.example.javase.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCommunicationLock {
    public static void main(String[] args) {
        Shared shared = new Shared();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        shared.increase();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }, "thread1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        shared.decrease();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        }, "thread2").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        shared.increase();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }, "thread3").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        shared.decrease();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        }, "thread4").start();
    }

}


/**
 * 0或1，为0时可+1，为1时可-1
 */
class Shared {
    private int num = 0;

    private final Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    /**
     * +1操作
     */
    public void increase() throws InterruptedException {
        lock.lock();
        try {
            // 判断
            while (num != 0) {
                condition.await();
            }
            // 工作
            num++;
            System.out.println(Thread.currentThread().getName() + ": " + num);
            // 通知其他线程
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    /**
     * -1操作
     */
    public void decrease() throws InterruptedException {
        lock.lock();
        try {
            // 判断
            while (num != 1) {
                condition.await();
            }
            // 工作
            num--;
            System.out.println(Thread.currentThread().getName() + ": " + num);
            // 通知其他线程
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}


