package com.example.javase.concurrent.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author wzklhk
 * @date 2022/7/29 11:28
 */
public class QueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> abq = new ArrayBlockingQueue<>(5);

        for (int i = 0; i < 10; i++) {
            System.out.printf("%d\t%b\t%d\n", i, abq.offer(i + 5, 1000, TimeUnit.MILLISECONDS), abq.element());
            System.out.println();
        }
    }
}
