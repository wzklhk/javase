package com.example.javase.concurrent.readwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author wzklhk
 * @date 2022/7/29 11:17
 */
public class WriteLockDowngradeReadLockDemo {
    public static void main(String[] args) {
        // 可重入读写锁对象
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        // 读锁
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        // 写锁
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();


        //锁降级
        // 1、写锁上锁
        writeLock.lock();
        System.out.println("wzklhhk");

        // 2、读锁上锁
        readLock.lock();
        System.out.println("read");

        // 3、写锁解锁
        writeLock.unlock();

        // 4、读锁解锁
        readLock.unlock();

    }
}
