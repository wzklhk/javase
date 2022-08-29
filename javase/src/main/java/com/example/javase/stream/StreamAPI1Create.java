package com.example.javase.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPI1Create {
    public static void main(String[] args) {
        // 通过Collection系列集合提供的stream()或parallelStream()
        List<Integer> list = new ArrayList<>();
        Stream<Integer> stream1 = list.stream();

        // 通过Arrays中的静态方法stream()获取流
        Integer[] ints = new Integer[10];
        Stream<Integer> stream2 = Arrays.stream(ints);

        // 通过Stream类中的静态方法of()获取流
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");

        // 创建无限流
        // 迭代
        Stream<Integer> stream4iterate = Stream.iterate(0, integer -> integer + 2); // 从seed开始按照运算规律产生无线流
        stream4iterate.limit(10).forEach(System.out::println);
        // 生成
        Stream stream4generate = Stream.generate(() -> Math.random());
        stream4generate.limit(10).forEach(System.out::println);
    }
}
