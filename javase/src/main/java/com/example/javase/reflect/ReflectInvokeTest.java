package com.example.javase.reflect;

import java.lang.reflect.Method;

public class ReflectInvokeTest {
    public static void main(String[] args) {
        User user = new User("admin", "admin123");

        Class<? extends User> cl = user.getClass();

        try {
            Method method = cl.getMethod("getUsername");
            String username = (String) method.invoke(user);
            System.out.println(username);

            Method mStatic = cl.getMethod("info", String.class);
            String a = "test";
            mStatic.invoke(null, a);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
