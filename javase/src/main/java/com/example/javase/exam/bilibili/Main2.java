package com.example.javase.exam.bilibili;

public class Main2 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);


        Solution2 s = new Solution2();
        System.out.println(s.maxValue(root));
    }
}
