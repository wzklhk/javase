package com.example.javase.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableImplTest {
    public static void main(String[] args) {

        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return null;
            }
        });


    }
}
