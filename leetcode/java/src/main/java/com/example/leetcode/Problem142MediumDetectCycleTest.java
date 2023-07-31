package com.example.leetcode;

import com.example.leetcode.structure.ListNode;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wzklhk
 * <p>
 * 给定一个链表的头节点 head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到
 * 链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 不允许修改 链表。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：返回索引为 1 的链表节点
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：返回索引为 0 的链表节点
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：返回 null
 * 解释：链表中没有环。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 链表中节点的数目范围在范围 [0, 10⁴] 内
 * -10⁵ <= Node.val <= 10⁵
 * pos 的值为 -1 或者链表中的一个有效索引
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：你是否可以使用 O(1) 空间解决此题？
 * <p>
 * Related Topics 哈希表 链表 双指针 👍 2210 👎 0
 * <p>
 * <p>
 * leetcode submit region begin(Prohibit modification and deletion)
 */

public class Problem142MediumDetectCycleTest {
    public ListNode detectCycleHash(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode p = head;
        while (p.next != null) {
            if (!set.contains(p)) {
                set.add(p);
            } else {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    public ListNode detectCycleSlowFast(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);

        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    @Test
    public void test() {
        ListNode head = new ListNode();
        ListNode p = head;
        int[] list = {3, 2, 0, -4};
        for (int i : list) {
            p.next = new ListNode(i);
            p = p.next;
        }
        p.next = head.next.next;
        ListNode listNode = detectCycleSlowFast(head.next);

        System.out.println(listNode);
    }
}
