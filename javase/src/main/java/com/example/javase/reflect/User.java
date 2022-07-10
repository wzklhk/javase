package com.example.javase.reflect;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String username;
    private String password;

    public static void info(String s) {
        System.out.println("information: " + s);

    }
}
