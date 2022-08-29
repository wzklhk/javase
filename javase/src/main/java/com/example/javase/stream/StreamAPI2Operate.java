package com.example.javase.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPI2Operate {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        Stream<Integer> stream = list.stream().filter((i) -> {
            System.out.println("中间操作");
            return i > 5;
        });
    }
}
