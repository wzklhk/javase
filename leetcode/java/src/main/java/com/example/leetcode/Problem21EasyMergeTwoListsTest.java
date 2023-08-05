package com.example.leetcode;

import com.example.leetcode.structure.ListNode;
import org.junit.Test;

/**
 * @author wzklhk
 * @date 2022/11/7 9:53
 * <p>
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 * <p>
 * <p>
 * Related Topics 递归 链表 👍 3212 👎 0
 * <p>
 * <p>
 * leetcode submit region begin(Prohibit modification and deletion)
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
