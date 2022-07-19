package com.example.javase.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectTest {
    public static void main(String[] args) {
        String name = "com.example.javase.reflect.bean.User";

        try {
            Class cl = Class.forName(name);  // 根据类名字获取类的Class
            Class superclass = cl.getSuperclass();
            String modifiers = Modifier.toString(cl.getModifiers());
            if (modifiers.length() > 0) {
                System.out.println("modifier: " + modifiers);
            }

            System.out.println("class: " + name);

            System.out.println("----------constructors--------");
            printConstructors(cl);

            System.out.println("----------methods-------------");
            printMethods(cl);

            System.out.println("----------fields--------------");
            printFields(cl);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void printConstructors(Class cl) {
        Constructor[] declares = cl.getDeclaredConstructors();
        for (Constructor c : declares) {
            String name = c.getName();
            String modifiers = Modifier.toString(c.getModifiers());
            if (modifiers.length() > 0) {
                System.out.println("modifier: " + modifiers);
            }
            System.out.println("name: " + name);

            Class[] parameterTypes = c.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                System.out.println("paramType: " + parameterTypes[i].getName());
            }
        }
    }

    public static void printMethods(Class cl) {
        Method[] declares = cl.getDeclaredMethods();
        for (Method m : declares) {
            String name = m.getName();
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0) {
                System.out.println("modifier: " + modifiers);
            }
            System.out.println("name: " + name);

            Class[] parameterTypes = m.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                System.out.println("paramType: " + parameterTypes[i].getName());
            }
        }
    }

    public static void printFields(Class cl) {
        Field[] fields = cl.getDeclaredFields();
        for (Field f : fields) {
            String name = f.getName();
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0) {
                System.out.println("modifier: " + modifiers);
            }
            System.out.println("name: " + name);
        }
    }

}
