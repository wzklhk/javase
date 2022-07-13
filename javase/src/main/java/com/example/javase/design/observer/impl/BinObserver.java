package com.example.javase.design.observer.impl;

import com.example.javase.design.observer.Observer;
import com.example.javase.design.observer.Subject;

public class BinObserver extends Observer {

    public BinObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void onUpdate() {
        System.out.println("BinObserver: " + Integer.toBinaryString(subject.getState()));
    }
}
