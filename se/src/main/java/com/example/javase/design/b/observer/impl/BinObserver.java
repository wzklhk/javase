package com.example.javase.design.b.observer.impl;

import com.example.javase.design.b.observer.Observer;
import com.example.javase.design.b.observer.Subject;

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
