package com.example.javase.reflect.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

    private String username;
    private String password;

    {
        System.out.println("this is user static code");
    }

    public User() {
        System.out.println("NoArgsConstructor");
    }

    public static void info(String s) {
        System.out.println("information: " + s);
    }
}
