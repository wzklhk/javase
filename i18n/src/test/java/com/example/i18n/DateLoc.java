package com.example.i18n;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class DateLoc {

    public static void main(String[] args) {
        System.out.println(DateLoc.convert(LocalDateTime.now(), Locale.ENGLISH));
    }

    public static String convert(LocalDateTime date, Locale loc) {

//        return DateFormat.getDateInstance(DateFormat.MEDIUM, loc).format(date);
        return DateTimeFormatter
                .ofLocalizedDateTime(FormatStyle.SHORT)
                .withLocale(loc)
                .format(date);

    }
}
