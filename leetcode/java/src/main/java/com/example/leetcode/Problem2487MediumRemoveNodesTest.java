package com.example.leetcode;

import com.example.leetcode.structure.ListNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author wzklhk
 * <p>
 * 给你一个链表的头节点 head 。
 * <p>
 * 对于列表中的每个节点 node ，如果其右侧存在一个具有 严格更大 值的节点，则移除 node 。
 * <p>
 * 返回修改后链表的头节点 head 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：head = [5,2,13,3,8]
 * 输出：[13,8]
 * 解释：需要移除的节点是 5 ，2 和 3 。
 * - 节点 13 在节点 5 右侧。
 * - 节点 13 在节点 2 右侧。
 * - 节点 8 在节点 3 右侧。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：head = [1,1,1,1]
 * 输出：[1,1,1,1]
 * 解释：每个节点的值都是 1 ，所以没有需要移除的节点。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 给定列表中的节点数目在范围 [1, 10⁵] 内
 * 1 <= Node.val <= 10⁵
 * <p>
 * <p>
 * Related Topics 栈 递归 链表 单调栈 👍 35 👎 0
 * <p>
 * <p>
 * leetcode submit region begin(Prohibit modification and deletion)
 */


public class Problem2487MediumRemoveNodesTest {

    public ListNode removeNodesRecursion(ListNode head) {
        if (head.next == null) {
            return head;
        }
        head.next = removeNodesRecursion(head.next);
        if (head.val < head.next.val) {
            return head.next;
        }
        return head;
    }

    public ListNode removeNodesStack(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();

        while (head != null) {
            while (!stack.isEmpty() && head.val > stack.peek().val) {
                stack.pop();
            }
            stack.push(head);
            head = head.next;
        }

        ListNode ans = new ListNode();
        while (!stack.isEmpty()) {
            ListNode q = ans.next;
            ans.next = stack.pop();
            ans.next.next = q;
        }
        return ans.next;
    }

    @Test
    public void test() {
        int[] list = {5, 2, 13, 3, 8};
        ListNode head = ListNode.toLinkedList(list);
        ListNode ans = removeNodesStack(head);

        ListNode.print(ans);
    }
}
