package com.example.leetcode;

import com.example.leetcode.structure.TreeNode;
import org.junit.Test;

/**
 * @author wzklhk
 * <p>
 * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定
 * 经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中节点数目范围是 [1, 3 * 10⁴]
 * -1000 <= Node.val <= 1000
 * <p>
 * <p>
 * Related Topics 树 深度优先搜索 动态规划 二叉树 👍 2051 👎 0
 * <p>
 * <p>
 * leetcode submit region begin(Prohibit modification and deletion)
 */

public class Problem124HardMaxPathSumTest {

    int maxSum = Integer.MIN_VALUE;


    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        int priceNewPath = node.val + leftGain + rightGain;

        maxSum = Math.max(maxSum, priceNewPath);

        return node.val + Math.max(leftGain, rightGain);
    }

    @Test
    public void test() {
        Integer[] treeList = {-10, 9, 20, null, null, 15, 7};
        TreeNode tree = TreeNode.toTree(treeList);

        int i = maxPathSum(tree);
        System.out.println(i);
    }
}
