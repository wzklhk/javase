package com.example.javase.design.observer.impl;

import com.example.javase.design.observer.Observer;
import com.example.javase.design.observer.Subject;

public class OctObserver extends Observer {

    public OctObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void onUpdate() {
        System.out.println("HexObserver: " + Integer.toOctalString(subject.getState()));
    }
}
