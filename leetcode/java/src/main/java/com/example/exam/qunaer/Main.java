package com.example.exam.qunaer;

import org.junit.Test;

/**
 * 比较版本号大小
 */
public class Main {
    public int compareVersion(String version1, String version2) {
        // write code here
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int n = Math.min(split1.length, split2.length);

        for (int i = 0; i < n; i++) {

            try {
                int v1 = Integer.parseInt(split1[i]);
                int v2 = Integer.parseInt(split2[i]);

                if (v1 > v2) {
                    return 1;
                } else if (v1 < v2) {
                    return -1;
                }
            } catch (Exception e) {
                break;
            }

        }

        return 0;
    }

    @Test
    public void test() {
        System.out.println(compareVersion("1.0.0.f", "0.1.0.f"));
    }
}