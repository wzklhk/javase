package com.example.javase.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SellTicketLock {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                Boolean isSold = ticket.sell();
                if (!isSold) {
                    break;
                }
            }

        }, "seller1").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                Boolean isSold = ticket.sell();
                if (!isSold) {
                    break;
                }
            }

        }, "seller2").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                Boolean isSold = ticket.sell();
                if (!isSold) {
                    break;
                }
            }

        }, "seller3").start();
    }
}


class Ticket {
    private int num = 100;

    private final Lock lock = new ReentrantLock();

    public Boolean sell() {

        lock.lock();  // 加锁

        try {
            if (num > 0) {
                System.out.println(Thread.currentThread().getName() + "卖票：" + num-- + "，剩余：" + num);
                if (isSoldOut()) {
                    return false;
                } else {
                    return true;
                }
            }
        } finally {
            lock.unlock();  // 解锁
        }

        return false;
    }

    public Boolean isSoldOut() {
        return num <= 0;
    }
}

