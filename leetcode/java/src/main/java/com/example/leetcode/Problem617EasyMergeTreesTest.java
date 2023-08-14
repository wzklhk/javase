package com.example.leetcode;

import com.example.leetcode.structure.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @author wzklhk
 * <p>
 * 给你两棵二叉树： root1 和 root2 。
 * <p>
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠
 * ，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 * <p>
 * 返回合并后的二叉树。
 * <p>
 * 注意: 合并过程必须从两个树的根节点开始。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
 * 输出：[3,4,5,5,4,null,7]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：root1 = [1], root2 = [1,2]
 * 输出：[2,2]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 两棵树中的节点数目在范围 [0, 2000] 内
 * -10⁴ <= Node.val <= 10⁴
 * <p>
 * <p>
 * Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1260 👎 0
 * <p>
 * <p>
 * leetcode submit region begin(Prohibit modification and deletion)
 */


public class Problem617EasyMergeTreesTest {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        TreeNode treeNode = new TreeNode();

        treeNode.val = (root1 != null ? root1.val : 0) + (root2 != null ? root2.val : 0);
        treeNode.left = mergeTrees(root1 != null && root1.left != null ? root1.left : null, root2 != null && root2.left != null ? root2.left : null);
        treeNode.right = mergeTrees(root1 != null && root1.right != null ? root1.right : null, root2 != null && root2.right != null ? root2.right : null);
        return treeNode;
    }

    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        TreeNode merged = new TreeNode(root1.val + root2.val);
        Queue<TreeNode> q = new ArrayDeque<>();
        Queue<TreeNode> q1 = new ArrayDeque<>();
        Queue<TreeNode> q2 = new ArrayDeque<>();

        q.offer(merged);
        q1.offer(root1);
        q2.offer(root2);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode node = q.poll();
            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();

            TreeNode left1 = node1.left;
            TreeNode left2 = node2.left;

            TreeNode right1 = node1.right;
            TreeNode right2 = node2.right;

            if (left1 != null || left2 != null) {
                if (left1 != null && left2 != null) {
                    TreeNode left = new TreeNode(left1.val + left2.val);
                    node.left = left;
                    q.offer(left);
                    q1.offer(left1);
                    q2.offer(left2);
                } else if (left1 != null) {
                    node.left = left1;
                } else {
                    node.left = left2;
                }
            }
            if (right1 != null || right2 != null) {
                if (right1 != null && right2 != null) {
                    TreeNode right = new TreeNode(right1.val + right2.val);
                    node.right = right;
                    q.offer(right);
                    q1.offer(right1);
                    q2.offer(right2);
                } else if (right1 != null) {
                    node.right = right1;
                } else {
                    node.right = right2;
                }
            }
        }
        return merged;
    }

    public TreeNode mergeTrees3(TreeNode root1, TreeNode root2) {
        Integer[] list1 = toList(root1);
        Integer[] list2 = toList(root2);

        int n1 = list1.length;
        int n2 = list2.length;
        Integer[] list = new Integer[Math.max(n1, n2)];

        int i = 0;
        while (i < n1 || i < n2) {
            if (i < n1 && i < n2) {
                if (list1[i] != null && list2[i] != null) {
                    list[i] = list1[i] + list2[i];
                } else if (list1[i] != null) {
                    list[i] = list1[i];
                } else if (list2[i] != null) {
                    list[i] = list2[i];
                } else {
                    list[i] = null;
                }
            } else if (i < n1) {
                list[i] = list1[i] == null ? null : list1[i];
            } else if (i < n2) {
                list[i] = list2[i] == null ? null : list2[i];
            }
            i++;
        }

        return toTree(list);
    }

    private TreeNode toTree(Integer[] treeList) {
        return toTreeHelper(treeList, 0);
    }

    private TreeNode toTreeHelper(Integer[] treeList, int i) {
        int n = treeList.length;
        Integer x = treeList[i];
        if (x == null) {
            return null;
        }
        TreeNode treeNode = new TreeNode(x);
        treeNode.left = i * 2 + 1 < n ? toTreeHelper(treeList, i * 2 + 1) : null;
        treeNode.right = i * 2 + 2 < n ? toTreeHelper(treeList, i * 2 + 2) : null;
        return treeNode;
    }

    private Integer[] toList(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        Queue<TreeNode> q = new ArrayDeque<>();
        do {
            list.add(cur.val);
            if (cur.val != null) {
                TreeNode left = cur.left;
                if (left == null) {
                    q.offer(new TreeNode());
                } else {
                    q.offer(left);
                }
                TreeNode right = cur.right;
                if (right == null) {
                    q.offer(new TreeNode());
                } else {
                    q.offer(right);
                }
            }
            cur = q.poll();
        } while (cur != null);

        return list.toArray(new Integer[0]);
    }


    @Test
    public void test() {
        Integer[] list1 = {1, 3, 2, 5};
        Integer[] list2 = {2, 1, 3, null, 4, null, 7};
        TreeNode root1 = TreeNode.toTree(list1);
        TreeNode root2 = TreeNode.toTree(list2);
        TreeNode treeNode = mergeTrees3(root1, root2);
        System.out.println(Arrays.toString(TreeNode.toList(treeNode)));
    }


}
