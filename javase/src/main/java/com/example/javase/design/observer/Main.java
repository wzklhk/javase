package com.example.javase.design.observer;

import com.example.javase.design.observer.impl.BinObserver;
import com.example.javase.design.observer.impl.HexObserver;
import com.example.javase.design.observer.impl.OctObserver;

public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new BinObserver(subject);
        new OctObserver(subject);
        new HexObserver(subject);


        subject.setState(1023);
        subject.setState(2047);

    }
}
