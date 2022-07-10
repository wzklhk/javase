package com.example.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceTest {
    public static void main(String[] args) {
        ResourceBundle bundle;

        bundle = ResourceBundle.getBundle("i18n/message", Locale.CHINA);
        System.out.println(bundle.getString("string"));

        bundle = ResourceBundle.getBundle("i18n/message", Locale.TAIWAN);
        System.out.println(bundle.getString("string"));

        bundle = ResourceBundle.getBundle("i18n/message", Locale.US);
        System.out.println(bundle.getString("string"));
    }
}
