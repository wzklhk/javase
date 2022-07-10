package com.example.i18n;

import java.text.NumberFormat;
import java.util.Locale;

public class NumLoc {
    public static void main(String[] args) {
        Locale loc = Locale.CHINA;
        String s = NumLoc.convert(123123123123123123L, loc);

        System.out.println(s);
    }

    public static String convert(Object o, Locale loc) {
        NumberFormat curFmt = NumberFormat.getCurrencyInstance(loc);
        return curFmt.format(o);
    }

}
