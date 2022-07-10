package com.example.javase.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Interview0406TreeNode {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) { // 利用二叉树特性

        TreeNode successor = null;

        // 二叉搜索树中序遍历的下一个节点搜索方法
        if (p.right != null) {
            successor = p.right;
            while (successor.left != null) {
                successor = successor.left;
            }
            return successor;
        }

        //
        TreeNode node = root;
        while (node != null) {
            if (node.val > p.val) { // p之后的节点
                successor = node;
                node = node.left;
            } else { // p之前的节点
                node = node.right;
            }
        }
        return successor;

    }

    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) { // 直接中序遍历

        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode prev = null, curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (prev == p) {
                return curr;
            }
            prev = curr;
            curr = curr.right;
        }
        return null;

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}


