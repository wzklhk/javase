package com.example.javase.exam.meituan2;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 91% 结果错误
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        int[] fathers = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            fathers[i] = in.nextInt();
        }
        in.nextLine();

        String types = in.nextLine();

        TreeNode[] list = new TreeNode[n];

        list[0] = new TreeNode(1, types.charAt(0));

        for (int i = 1; i < n; i++) {
            list[i] = new TreeNode(i + 2, types.charAt(i));
        }

        for (int i = 0; i < fathers.length; i++) {

            list[fathers[i] - 1].children.add(list[i + 1]);
        }

        for (int i = 0; i < list.length; i++) {
            TreeNode root = list[i];
            HashSet<Character> set = new HashSet<>();
            solve(root, set);
            System.out.print(set.size() + " ");
        }
    }


    private static void solve(TreeNode root, Set<Character> types) {
        if (root == null) {
            return;
        }
        types.add(root.type);
        for (TreeNode child : root.children) {
            solve(child, types);
        }
    }

}

class TreeNode {
    public int id;
    public Character type;
    Set<TreeNode> children = new HashSet<>();

    public TreeNode(int id, Character type) {
        this.id = id;
        this.type = type;
    }
}
