package com.example.exam.bilibili;

public class Solution1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode mergeNode(ListNode head) {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return null;
        }
        int tmp = head.val;
        head = head.next;
        tmp *= head.val;
        head = head.next;

        ListNode result = new ListNode(tmp);
        ListNode resIter = result;

        int i = 2;
        tmp = 1;
        while (head != null) {
            tmp *= head.val;
            i++;
            if (i % 2 == 0) {
                resIter.next = new ListNode(tmp);
                resIter = resIter.next;
                tmp = 1;
            }
            head = head.next;
        }
        return result;
    }
}



