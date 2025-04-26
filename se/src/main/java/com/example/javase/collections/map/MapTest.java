package com.example.javase.collections.map;

import java.util.HashMap;

public class MapTest {
    public static void main(String[] args) {
        HashMap<Integer, String> sites = new HashMap<>();

        sites.put(1, "google");
        sites.put(2, "facebook");
        sites.put(3, "twitter");
        sites.put(4, "amazon");

        System.out.println("sites = " + sites);

        for (Integer i : sites.keySet()) {
            System.out.println("key: " + i + " value: " + sites.get(i));

        }
    }
}
