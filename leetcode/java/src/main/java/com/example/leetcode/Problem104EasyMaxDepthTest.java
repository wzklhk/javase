package com.example.leetcode;


/**
 * @author wzklhk
 * <p>
 * 给定一个二叉树 root ，返回其最大深度。
 * <p>
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：3
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1,null,2]
 * 输出：2
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 树中节点的数量在 [0, 10⁴] 区间内。
 * -100 <= Node.val <= 100
 * <p>
 * <p>
 * Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1683 👎 0
 */

import com.example.leetcode.structure.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Problem104EasyMaxDepthTest {
    public int maxDepthDFS(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(maxDepthDFS(root.left), maxDepthDFS(root.right)) + 1;
        }
    }

    public int maxDepthBFS(TreeNode root) {
        int depth = 0;

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            depth++;
        }
        return depth;
    }


    @Test
    public void test() {
        Integer[] treeList = {3, 9, 20, null, null, 15, 7};
        TreeNode tree = TreeNode.toTree(treeList);

        int i = maxDepthBFS(tree);
        System.out.println(i);
    }
}
