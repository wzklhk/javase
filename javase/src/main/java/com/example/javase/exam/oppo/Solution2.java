package com.example.javase.exam.oppo;

import java.util.ArrayList;
import java.util.Collections;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class Solution2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param node1 ListNode类
     * @param node2 ListNode类
     * @return ListNode类
     */
    public ListNode combineTwoDisorderNodeToOrder(ListNode node1, ListNode node2) {
        // write code here

        ArrayList<Integer> list = new ArrayList<>();
        ListNode p = node1;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        p = node2;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }

        Collections.sort(list);

        ListNode result = new ListNode(list.get(0));
        p = result;

        for (int i = 1; i < list.size(); i++) {
            p.next = new ListNode(list.get(i));
            p = p.next;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(3);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(1);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(2);

        Solution2 p = new Solution2();
        p.combineTwoDisorderNodeToOrder(node1, node2);
    }
}