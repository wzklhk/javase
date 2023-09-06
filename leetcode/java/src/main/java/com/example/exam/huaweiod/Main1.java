package com.example.exam.huaweiod;

import java.util.*;

/**
 * C 语言有一个库函数： char *strstr(const char *haystack, const char *needle) ，实现在字符串 haystack 中查找第一次出现字符串 needle 的位置，如果未找到则返回 null。
 * <p>
 * 现要求实现一个 strstr 的增强函数，可以使用带可选段的字符串来模糊查询，与 strstr 一样返回首次查找到的字符串位置。
 * <p>
 * 可选段使用 “[]” 标识，表示该位置是可选段中任意一个字符即可满足匹配条件。比如 “a[bc]” 表示可以匹配 “ab” 或 “ac”。 注意目标字符串中可选段可能出现多次。
 * <p>
 * 输入描述
 * 与 strstr 函数一样，输入参数是两个字符串指针，分别是源字符串和目标字符串。
 * <p>
 * 输出描述
 * 与 strstr 函数不同，返回的是源字符串中，匹配子字符串相对于源字符串地址的偏移（从 0 开始算），如果没有匹配返回-1。
 * <p>
 * 补充说明
 * 源字符串中必定不包含 ‘[]’；目标字符串中 ‘[]’ 必定成对出现，且不会出现嵌套。
 * <p>
 * 输入的字符串长度在[1,100]之间。
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String haystack = in.nextLine();
        String needle = in.nextLine();

        System.out.println(solve(haystack, needle));

        System.out.println(haystack.matches(needle));
    }

    private static int solve(String haystack, String needle) {
        List<Character> haystackList = new ArrayList<>();
        for (char c : haystack.toCharArray()) {
            haystackList.add(c);
        }
        List<Set<Character>> needleList = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < needle.length(); i++) {
            if (needle.charAt(i) == '[') {
                flag = true;
            } else if (needle.charAt(i) == ']') {
                flag = false;
            } else {
                Set<Character> list = new HashSet<>();
                if (!flag) {
                    list.add(needle.charAt(i));
                } else {
                    while (needle.charAt(i) != ']') {
                        list.add(needle.charAt(i));
                        i++;
                    }
                }
                needleList.add(list);
            }
        }
        return strStr(haystackList, needleList);
    }


    private static int strStr(List<Character> haystack, List<Set<Character>> needles) {
        int hl = haystack.size();
        int nl = needles.size();
        for (int i = 0; i + nl <= hl; i++) {
            boolean flag = true;
            for (int j = 0; j < nl; j++) {
                if (!needles.get(j).contains(haystack.get(i + j))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }


}
