package com.example.leetcode;

/**
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * <p>
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层
 * 为第 h 层，则该层包含 1~ 2ʰ 个节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = []
 * 输出：0
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [1]
 * 输出：1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中节点的数目范围是[0, 5 * 10⁴]
 * 0 <= Node.val <= 5 * 10⁴
 * 题目数据保证输入的树是 完全二叉树
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？
 * <p>
 * Related Topics 树 深度优先搜索 二分查找 二叉树 👍 771 👎 0
 * <p>
 * <p>
 * leetcode submit region begin(Prohibit modification and deletion)
 */


public class Problem222CountNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;

        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
