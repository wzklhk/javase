package com.example.leetcode.structure;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode toLinkedList(int[] list) {
        ListNode ans = new ListNode();
        ListNode p = ans;
        for (int i : list) {
            p.next = new ListNode(i);
            p = p.next;
        }
        return ans.next;
    }

    public static void print(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}