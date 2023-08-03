package com.example.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wzklhk
 */
public class Problem722MediumRemoveCommentsTest {
    public List<String> removeComments(String[] source) {
        ArrayList<String> res = new ArrayList<>();
        boolean inComment = false;
        StringBuilder newLine = new StringBuilder();
        for (String s : source) {
            for (int i = 0; i < s.length(); i++) {
                if (inComment) {
                    if (i + 1 < s.length() && s.charAt(i) == '*' && s.charAt(i + 1) == '/') {
                        inComment = false;
                        i++;
                    }
                } else {
                    if (i + 1 < s.length() && s.charAt(i) == '/' && s.charAt(i + 1) == '*') {
                        inComment = true;
                        i++;
                    } else if (i + 1 < s.length() && s.charAt(i) == '/' && s.charAt(i + 1) == '/') {
                        break;
                    } else {
                        newLine.append(s.charAt(i));
                    }
                }
            }

            if (!inComment && newLine.length() > 0) {
                res.add(newLine.toString());
                newLine.setLength(0);
            }
        }
        return res;
    }

    @Test
    public void test() {
        String[] source = {
                "/*Test program */",
                "int main()", "{ ",
                " // variable declaration ",
                "int a, b, c;",
                "/* This is a test",
                " multiline ",
                " comment for ",
                " testing */",
                "a = b + c;",
                "}"};
        String[] source2 = {
                "a/*comment",
                "line",
                "more_comment*/b"
        };
        List<String> strings = removeComments(source2);
        strings.forEach(System.out::println);
    }
}
