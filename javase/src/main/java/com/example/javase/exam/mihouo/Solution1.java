package com.example.javase.exam.mihouo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param preorder int整型一维数组
     * @param inorder  int整型一维数组
     * @return int整型
     */
    public int maxPathSum(int[] preorder, int[] inorder) {
        // write code here
        ArrayList<Integer> preorderList = new ArrayList<>();
        ArrayList<Integer> inorderList = new ArrayList<>();
        for (int i : preorder) {
            preorderList.add(i);
        }
        for (int i : inorder) {
            inorderList.add(i);
        }

        TreeNode tree = getTree(preorderList, inorderList);

        int result = 0;
        while (tree != null) {
            result += tree.val;
            if (tree.left != null && tree.right != null) {
                tree = tree.left.val > tree.right.val ? tree.left : tree.right;
            } else if (tree.left != null && tree.right == null) {
                tree = tree.left;
            } else if (tree.left == null && tree.right != null) {
                tree = tree.right;
            } else {
                break;
            }
        }
        return result;
    }

    private TreeNode getTree(List<Integer> preorder, List<Integer> inorder) {
        if (preorder.size() == 0 || inorder.size() == 0) {
            return null;
        }
        Integer root = preorder.get(0);
        TreeNode result = new TreeNode(root);

        List<Integer> inorder1 = new ArrayList<>();
        List<Integer> inorder2 = new ArrayList<>();
        List<Integer> preorder1 = new ArrayList<>();
        List<Integer> preorder2 = new ArrayList<>();

        boolean flag = false;
        for (int i = 0; i < inorder.size(); i++) {
            if (!flag && !inorder.get(i).equals(root)) {
                inorder1.add(inorder.get(i));
            } else if (inorder.get(i).equals(root)) {
                flag = true;
            } else if (flag && !inorder.get(i).equals(root)) {
                inorder2.add(inorder.get(i));
            }
        }

        for (int i = 0; i < preorder.size(); i++) {
            if (inorder1.contains(preorder.get(i))) {
                preorder1.add(preorder.get(i));
            } else if (inorder2.contains(preorder.get(i))) {
                preorder2.add(preorder.get(i));
            }
        }

        result.left = getTree(preorder1, inorder1);
        result.right = getTree(preorder2, inorder2);
        return result;
    }

    public static void main(String[] args) {
        Integer[] preorder = {3, 9, 20, 15, 7};
        Integer[] inorder = {9, 3, 15, 20, 7};
        Solution1 s = new Solution1();
        TreeNode tree = s.getTree(Arrays.asList(preorder), Arrays.asList(inorder));
        System.out.println(tree);
    }
}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}