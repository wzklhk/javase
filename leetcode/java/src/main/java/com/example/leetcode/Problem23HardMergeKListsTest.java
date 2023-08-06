package com.example.leetcode;

import com.example.leetcode.structure.ListNode;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author wzklhk
 * <p>
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 * <p>
 * <p>
 * Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2509 👎 0
 * <p>
 * <p>
 * leetcode submit region begin(Prohibit modification and deletion)
 */


public class Problem23HardMergeKListsTest {
    Problem21EasyMergeTwoListsTest p21 = new Problem21EasyMergeTwoListsTest();

    public ListNode mergeKListsMergeTwo(ListNode[] lists) {
        ListNode res = null;
        for (ListNode list : lists) {
            res = p21.mergeTwoListsIter(list, res);
        }
        return res;
    }

    public ListNode mergeKListsMergeTwoDC(ListNode[] lists) {
        return mergeDC(lists, 0, lists.length - 1);
    }

    public ListNode mergeDC(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) / 2;
        return p21.mergeTwoListsIter(mergeDC(lists, l, mid), mergeDC(lists, mid + 1, r));
    }

    public ListNode mergeKListsPriorityQueue(ListNode[] lists) {

        Queue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            while (list != null) {
                pq.offer(list);
                list = list.next;
            }
        }

        ListNode res = new ListNode();
        ListNode p = res;
        while (!pq.isEmpty()) {
            p.next = pq.poll();
            p = p.next;
        }
        p.next = null;

        return res.next;
    }

    @Test
    public void test() {

        int[][] lists = {{1, 4, 5}, {2, 6}, {1, 3, 4}};


        ListNode[] linkedLists = new ListNode[lists.length];
        for (int i = 0; i < lists.length; i++) {
            ListNode head = new ListNode();
            ListNode p = head;
            for (int j : lists[i]) {
                p.next = new ListNode(j);
                p = p.next;
            }
            linkedLists[i] = head.next;
        }

        ListNode ans = mergeKListsPriorityQueue(linkedLists);

        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
