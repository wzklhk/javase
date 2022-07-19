package com.example.javase.concurrent.sync;

// 1、创建资源类，在资源类创建属性和操作方法
// 2、创建多个线程，调用资源类的操作方法

public class SellTicket {
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
    private int num = 30;

    public synchronized Boolean sell() {
        if (num > 0) {
            System.out.println(Thread.currentThread().getName() + "卖票：" + num-- + "，剩余：" + num);
            return true;
        } else {
            return false;
        }
    }
}
