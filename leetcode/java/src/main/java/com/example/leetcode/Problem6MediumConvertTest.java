package com.example.leetcode;

import org.junit.Test;

/**
 * @author wzklhk
 */
public class Problem6MediumConvertTest {
    public String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder();
        }

        int j = 0;
        int flag = -1;
        for (int i = 0; i < s.length(); i++) {
            sb[j].append(s.charAt(i));
            if (j == 0 || j == numRows - 1) {
                flag = -flag;
            }
            j += flag;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder i : sb) {
            res.append(i);
        }
        return res.toString();
    }

    @Test
    public void test() {
        String s = "ab";
        int numRows = 1;
        String convert = convert(s, numRows);
        System.out.println(convert);
    }
}
