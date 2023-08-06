package com.example.leetcode;

import com.example.leetcode.structure.ListNode;
import org.junit.Test;

/**
 * @author wzklhk
 * <p>
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = []
 * 输出：[]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：head = [1]
 * 输出：[1]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 * <p>
 * <p>
 * Related Topics 递归 链表 👍 1922 👎 0
 * <p>
 * <p>
 * leetcode submit region begin(Prohibit modification and deletion)
 */

public class Problem24MediumSwapPairsTest {
    public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode();

        ListNode p = head;
        ListNode q = res;

        while (p != null && p.next != null) {
            q.next = new ListNode(p.next.val);
            q.next.next = new ListNode(p.val);

            p = p.next.next;
            q = q.next.next;
        }

        if (p != null) {
            q.next = new ListNode(p.val);
        }

        return res.next;
    }

    public ListNode swapPairs2(ListNode head) {
        ListNode res = new ListNode();

        res.next = head;
        ListNode tmp = res;

        while (tmp.next != null && tmp.next.next != null) {
            ListNode start = tmp.next;
            ListNode end = tmp.next.next;

            tmp.next = end;
            start.next = end.next;
            end.next = start;
            tmp = start;
        }

        return res.next;
    }

    public ListNode swapPairsRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairsRecursion(next.next);
        next.next = head;
        return next;
    }

    @Test
    public void test() {
        int[] list = {1, 2, 3, 4, 5};
        ListNode head = new ListNode();
        ListNode p = head;
        for (int i : list) {
            p.next = new ListNode(i);
            p = p.next;
        }

        ListNode listNode = swapPairsRecursion(head.next);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
