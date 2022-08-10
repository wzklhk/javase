package com.example.javase.exam.lenovo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Stone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String aliceStr = sc.nextLine();
        String bobStr = sc.nextLine();

        List<String> aliceList = Arrays.asList(aliceStr.split(" "));
        List<String> bobList = Arrays.asList(bobStr.split(" "));

        int aliceScore = 0;
        int bobScore = 0;
        for (int i = 0; i < n; i++) {
            switch (win(aliceList.get(i), bobList.get(i))) {
                case 1:
                    aliceScore++;
                    break;
                case -1:
                    bobScore++;
                    break;
                default:
                    break;
            }
        }

        System.out.println(aliceScore + " " + bobScore);
    }

    public static int win(String a, String b) {
        if (!((a.equals("Rock") || a.equals("Scissor") || a.equals("Paper")) && (b.equals("Rock") || b.equals("Scissor") || b.equals("Paper")))) {
            return 100;
        }
        if (a.equals(b)) {
            return 0;
        } else if (a.equals("Rock") && b.equals("Scissor") ||
                a.equals("Scissor") && b.equals("Paper") ||
                a.equals("Paper") && b.equals("Rock")) {
            return 1;
        } else {
            return -1;
        }
    }
}
