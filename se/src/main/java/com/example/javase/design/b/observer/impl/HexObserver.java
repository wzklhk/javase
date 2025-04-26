package com.example.javase.design.b.observer.impl;

import com.example.javase.design.b.observer.Observer;
import com.example.javase.design.b.observer.Subject;

public class HexObserver extends Observer {

    public HexObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void onUpdate() {
        System.out.println("HexObserver: " + Integer.toHexString(subject.getState()));
    }
}
