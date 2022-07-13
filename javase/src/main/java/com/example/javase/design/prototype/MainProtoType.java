package com.example.javase.design.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

public class MainProtoType {
    public static void main(String[] args) {
        Integer a = 10;
        Integer b = a;
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(a == b);
        a = 11;
        System.out.println(a.toString());
        System.out.println(b.toString());


        Stu stu1 = new Stu("name1", 22);
        Stu stu2 = stu1;
        System.out.println(stu1.toString());
        System.out.println(stu2.toString());
        System.out.println(stu1 == stu2);
        stu1.setAge(33);
        System.out.println(stu1.toString());
        System.out.println(stu2.toString());
    }
}

@Data
@AllArgsConstructor
class Stu {
    private String name;
    private Integer age;
}

