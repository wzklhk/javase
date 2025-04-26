package com.example.javase.concurrent.readwritelock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                myCache.put(String.valueOf(finalI), finalI);
            }, String.valueOf(i)).start();
        }
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                myCache.get(String.valueOf(finalI));
            }, String.valueOf(i)).start();
        }
    }
}

class MyCache {

    public ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private volatile Map<String, Object> map = new HashMap<>();

    public void put(String key, Object value) {


        rwLock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "正在写数据");
            TimeUnit.MILLISECONDS.sleep(1000);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "完成写数据");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public Object get(String key) {


        rwLock.readLock().lock();
        Object o = null;

        try {
            System.out.println(Thread.currentThread().getName() + "正在读数据");
            TimeUnit.MILLISECONDS.sleep(1000);
            o = map.get(key);
            System.out.println(Thread.currentThread().getName() + "完成读数据");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.readLock().unlock();

        }

        return o;

    }
}
