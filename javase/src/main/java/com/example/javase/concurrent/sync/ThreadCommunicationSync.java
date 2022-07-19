package com.example.javase.concurrent.sync;

public class ThreadCommunicationSync {
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

    /**
     * +1操作
     */
    public synchronized void increase() throws InterruptedException {
        // 判断
        while (num != 0) {
            this.wait();
        }
        // 工作
        num++;
        System.out.println(Thread.currentThread().getName() + ": " + num);
        // 通知其他线程
        this.notifyAll();
    }

    /**
     * -1操作
     */
    public synchronized void decrease() throws InterruptedException {
        // 判断
        while (num != 1) {
            this.wait();
        }
        // 工作
        num--;
        System.out.println(Thread.currentThread().getName() + ": " + num);
        // 通知其他线程
        this.notifyAll();
    }
}


