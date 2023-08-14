package com.example.leetcode.structure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    public static TreeNode toTree(Integer[] treeList) {
        return toTreeHelper(treeList, 0);
    }

    private static TreeNode toTreeHelper(Integer[] treeList, int i) {
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

    public static Integer[] toList(TreeNode root) {
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

    public static Integer[] levelOrder(TreeNode root) {
        Queue<TreeNode> q = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        if (root != null) {
            q.offer(root);
        }
        while (!q.isEmpty()) {
            TreeNode poll = q.poll();
            list.add(poll.val);
            if (poll.left != null) {
                q.offer(poll.left);
            }
            if (poll.right != null) {
                q.offer(poll.right);
            }
        }

        return list.toArray(new Integer[0]);
    }
}
