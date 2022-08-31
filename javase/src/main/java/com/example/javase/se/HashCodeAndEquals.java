package com.example.javase.se;

import java.util.Objects;

public class HashCodeAndEquals {
    public static void main(String[] args) {
        User user1 = new User("user1");
        User user2 = new User("user1");

//        System.out.println(user1 == user2);
//        System.out.println(user1.equals(user2));

//        int a = 10;
//        Integer b = 10;
//        Integer c = new Integer(10);
//
//        System.out.println(a == b);  // true
//        System.out.println(b == c);  // false
//        System.out.println(b.equals(c));  // true

        System.out.println(user1 instanceof Object);
    }
}

class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
