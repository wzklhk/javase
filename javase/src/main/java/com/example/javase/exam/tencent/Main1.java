package com.example.javase.exam.tencent;

import org.junit.Test;

public class Main1 {
    public ListNode xorList(ListNode a, ListNode b) {
        // write code here
        ListNode ra = reverse(a);

        ListNode result = new ListNode(xor(ra.val, b.val));
        ListNode p = result;
        ra = ra.next;
        b = b.next;
        while (ra != null || b != null) {
            if (ra != null && b != null) {
                p.next = new ListNode(xor(ra.val, b.val));
                ra = ra.next;
                b = b.next;
            } else if (ra != null && b == null) {
                p.next = new ListNode(xor(ra.val, 0));
                ra = ra.next;
            } else {
                p.next = new ListNode(xor(0, b.val));
                b = b.next;
            }
            p = p.next;
        }
        ListNode reverse = reverse(result);
        while (reverse.val == 0) {
            if (reverse.next != null) {
                reverse = reverse.next;
            } else {
                return null;
            }
        }
        return reverse;
    }

    private ListNode reverse(ListNode a) {
        ListNode result = new ListNode(a.val);
        a = a.next;
        while (a != null) {
            ListNode l = new ListNode(a.val);
            a = a.next;
            l.next = result;
            result = l;
        }

        return result;
    }

    private int xor(int a, int b) {
        return a == b ? 0 : 1;
    }

    @Test
    public void test() {
        ListNode a = new ListNode(1);
        a.next = new ListNode(0);
        a.next.next = new ListNode(1);
        a.next.next.next = new ListNode(1);

        ListNode b = new ListNode(0);
        b.next = new ListNode(1);

        ListNode l = xorList(a, b);
        System.out.println(l);
    }
}

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}
