package com.example.i18n;

import com.example.i18n.common.util.Translation;

import java.util.Locale;

public class GetTextTest {
    private static final void translate(Translation tool) {
        //普通翻译
        System.out.println(tool.gettext("Hello"));
        System.out.println(tool.gettext("apple"));
        System.out.println(tool.gettext("banana"));
        System.out.println(tool.gettext("cherry"));
        System.out.println(tool.gettext("peach"));
        System.out.println(tool.gettext("grape"));



        /*//上下文翻译
        System.out.println(tool._x("post", "a post"));
        System.out.println(tool._x("post", "to post"));

        //单复数翻译
        System.out.printf(tool._n("%d comment\n", "%d comments\n", 1), 1);
        System.out.printf(tool._n("%d comment\n", "%d comments\n", 2), 2);

        //上下文相关的单复数翻译
        System.out.printf(tool._nx("%d comment\n", "%d comments\n", 1, "another context"), 1);
        System.out.printf(tool._nx("%d comment\n", "%d comments\n", 2, "another context"), 2);*/

    }

    public static void main(String[] args) {
        //中文环境
        System.out.println("-----中文-------------------------------------------");
        Translation zhcn = Translation.init(new Locale("zh", "CN"));
        translate(zhcn);

        //繁体中文
        System.out.println("-----繁中-------------------------------------------");
        Translation zhtw = Translation.init(new Locale("zh", "TW"));
        translate(zhtw);

        System.out.println("-----英文-------------------------------------------");
        //英文环境
        Translation enus = Translation.init(new Locale("en", "US"));
        translate(enus);


    }
}
