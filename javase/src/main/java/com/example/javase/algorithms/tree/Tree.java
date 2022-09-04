package com.example.javase.algorithms.tree;

import java.util.List;

public class Tree {

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
    }

    public boolean isBalance(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1
                && isBalance(root.left)
                && isBalance(root.right);
    }

    public void preorder(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorder(root.left, list);
            preorder(root.right, list);
        }
    }

    public void postorder(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            postorder(root.left, list);
            postorder(root.right, list);
            list.add(root);
        }
    }

    public void inorder(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            inorder(root.left, list);
            list.add(root);
            inorder(root.right, list);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        Tree t = new Tree();
        System.out.println(t.getDepth(root));
    }
}
