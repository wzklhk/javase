package com.example.exam;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        ListNode head = new ListNode(in.nextInt());
        ListNode p = head;
        for (int i = 1; i < n; i++) {
            p.next = new ListNode(in.nextInt());
            p = p.next;
        }
        in.nextLine();

        delete(head, in.nextInt());

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }

    public static void delete(ListNode head, int n) {
        ListNode left = head;
        ListNode right = head;

        for (int i = 0; i < n; i++) {
            if (right.next != null) {
                right = right.next;
            } else {
                return;
            }

        }

        while (right.next != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;
    }
}

class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}


