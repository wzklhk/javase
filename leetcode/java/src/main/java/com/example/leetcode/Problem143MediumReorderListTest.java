package com.example.leetcode;

import com.example.leetcode.structure.ListNode;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author wzklhk
 * <p>
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * <p>
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * <p>
 * <p>
 * 请将其重新排列后变为：
 * <p>
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * <p>
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 链表的长度范围为 [1, 5 * 10⁴]
 * 1 <= node.val <= 1000
 * <p>
 * <p>
 * Related Topics 栈 递归 链表 双指针 👍 1283 👎 0
 * <p>
 * <p>
 * leetcode submit region begin(Prohibit modification and deletion)
 */

public class Problem143MediumReorderListTest {
    public void reorderListArrayList(ListNode head) {
        ListNode p = head;
        ArrayList<ListNode> list = new ArrayList<>();
        while (p != null) {
            list.add(p);
            p = p.next;
        }

        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

    public void reorderListRecursion(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        int len = 0;
        ListNode p = head;
        while (p != null) {
            len++;
            p = p.next;
        }

        reorderListRecursionHelper(head, len);
    }

    public ListNode reorderListRecursionHelper(ListNode head, int len) {
        if (len == 1) {
            ListNode next = head.next;
            head.next = null;
            return next;
        } else if (len == 2) {
            ListNode next = head.next.next;
            head.next.next = null;
            return next;
        }

        ListNode tail = reorderListRecursionHelper(head.next, len - 2);
        ListNode subHead = head.next;
        head.next = tail;
        ListNode outTail = tail.next;
        tail.next = subHead;
        return outTail;
    }


    public void reorderListMid(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode mid = middleNode(head);


        ListNode l1 = head;
        ListNode l2 = reverseList(mid);

        while (l1 != null && l2 != null) {
            ListNode l1tmp = l1.next;
            ListNode l2tmp = l2.next;
            l1.next = l2;
            l1 = l1tmp;
            l2.next = l1;
            l2 = l2tmp;
        }
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        while (head.next != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        head.next = prev;
        return head;
    }

    @Test
    public void test() {
        ListNode head = new ListNode();
        ListNode p = head;
        int[] list = {1, 2, 3, 4, 5};
        for (int i : list) {
            p.next = new ListNode(i);
            p = p.next;
        }

        reorderListMid(head.next);

        p = head.next;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

}
