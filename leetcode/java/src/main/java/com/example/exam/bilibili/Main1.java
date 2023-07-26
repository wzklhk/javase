package com.example.exam.bilibili;

public class Main1 {
    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        ListNode headIter = head;

        headIter.next = new ListNode(3);
        headIter = headIter.next;
        headIter.next = new ListNode(5);
        headIter = headIter.next;
        headIter.next = new ListNode(1);
        headIter = headIter.next;
        headIter.next = new ListNode(4);
        headIter = headIter.next;
        headIter.next = new ListNode(7);
        headIter = headIter.next;

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
