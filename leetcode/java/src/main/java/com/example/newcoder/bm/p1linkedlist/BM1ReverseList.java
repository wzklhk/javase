package com.example.newcoder.bm.p1linkedlist;

/**
 * 给定一个单链表的头结点pHead(该头节点是有值的，比如在下图，它的val是1)，长度为n，反转该链表后，返回新链表的表头。
 * <p>
 * 数据范围： 0\leq n\leq10000≤n≤1000
 * 要求：空间复杂度 O(1)O(1) ，时间复杂度 O(n)O(n) 。
 * <p>
 * 如当输入链表{1,2,3}时，
 * 经反转后，原链表变为{3,2,1}，所以对应的输出为{3,2,1}。
 * 以上转换过程如下图所示：
 */

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/

public class BM1ReverseList {
    public ListNode ReverseList(ListNode head) {
        ListNode result = null;
        while (head != null) {
            ListNode newNode = new ListNode(head.val);
            newNode.next = result;
            result = newNode;
            head = head.next;
        }

        return result;
    }
}
