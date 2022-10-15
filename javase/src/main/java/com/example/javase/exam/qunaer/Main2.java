package com.example.javase.exam.qunaer;

import org.junit.Test;

public class Main2 {
    public int Decrypt(int encryptedNumber, int decryption, int number) {
        // write code here
        return 0;
    }

    private long power(long a, long n) {
        long r = 1;
        if (n == 0) {
            r = 1;
        } else {
            r = a * power(a, n - 1);
        }
        return r;

    }

    @Test
    public void test() {
//        System.out.println(Decrypt(4296,1601,4757));
        System.out.println(4296 * 4296 * 4296 % 4757);
        System.out.println(-12 % 13);
    }
}
