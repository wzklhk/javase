package com.example.javase.exam.bilibili2;

public class Solution1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode longestList(ListNode head) {
        ListNode result1 = new ListNode(head.val);
        ListNode p = result1;
        boolean isOdd = p.val % 2 == 1;
        ListNode phead1 = head.next;
        while (phead1 != null) {
            if (isOdd) {
                if (phead1.val % 2 == 0) {
                    p.next = new ListNode(phead1.val);
                    p = p.next;
                    isOdd = !isOdd;
                }
            } else {
                if (phead1.val % 2 == 1) {
                    p.next = new ListNode(phead1.val);
                    p = p.next;
                    isOdd = !isOdd;
                }
            }
            phead1 = phead1.next;
        }

        ListNode result2 = new ListNode(head.next.val);
        ListNode p2 = result2;
        isOdd = p2.val % 2 == 1;
        ListNode phead2 = head.next.next;
        while (phead2 != null) {
            if (isOdd) {
                if (phead2.val % 2 == 0) {
                    p2.next = new ListNode(phead2.val);
                    p2 = p2.next;
                    isOdd = !isOdd;
                }
            } else {
                if (phead2.val % 2 == 1) {
                    p2.next = new ListNode(phead2.val);
                    p2 = p2.next;
                    isOdd = !isOdd;
                }
            }
            phead2 = phead2.next;
        }
        int l1 = lengthListNode(result1);
        int l2 = lengthListNode(result2);

        return l1 > l2 ? result1 : result2;

    }

    private int lengthListNode(ListNode head) {
        int result = 0;
        while (head != null) {
            result++;
            head = head.next;
        }
        return result;
    }

}
