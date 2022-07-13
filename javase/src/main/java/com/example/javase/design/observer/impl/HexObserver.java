package com.example.javase.design.observer.impl;

import com.example.javase.design.observer.Observer;
import com.example.javase.design.observer.Subject;

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
