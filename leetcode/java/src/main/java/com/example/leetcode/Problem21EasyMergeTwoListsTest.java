package com.example.leetcode;

import org.junit.Test;

/**
 * @author wzklhk
 * @date 2022/11/7 9:53
 */
public class Problem21EasyMergeTwoListsTest {
    public ListNode mergeTwoListsIter(ListNode list1, ListNode list2) {
        ListNode l1 = list1;
        ListNode l2 = list2;

        ListNode preAns = new ListNode(-1);
        ListNode p = preAns;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                p.next = l2;
                l2 = l2.next;
            } else {
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }

        p.next = l1 == null ? l2 : l1;

        return preAns.next;
    }

    public ListNode mergeTwoListsRecursion(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoListsRecursion(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRecursion(list1, list2.next);
            return list2;
        }
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode ans = mergeTwoListsIter(l1, l2);

        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
