package com.example.javase.exam.bilibili;/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 *   public TreeNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return int整型
     */
    public int maxValue(TreeNode root) {
        // write code here

        levelOrder(root, 0);

        int maxLevel = Integer.MIN_VALUE;
        int maxLevelLevel = -1;
        int maxLevelMinValue = Integer.MAX_VALUE;
        for (int i = 0; i < levels.size(); i++) {
            List<TreeNode> level = levels.get(i);
            int sum = 0;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < level.size(); j++) {
                min = Math.min(min, level.get(j).val);
                sum += level.get(j).val;
            }
            if (sum > maxLevel) {
                maxLevel = sum;
                maxLevelLevel = i;
                maxLevelMinValue = min;
            }
        }

        List<TreeNode> level = levels.get(maxLevelLevel + 1);
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < level.size(); i++) {
            if (level.get(i).val > maxVal) {
                maxVal = level.get(i).val;
            }
        }

        return Math.max(maxLevel, maxLevel - maxLevelMinValue + maxVal);

    }

    public List<List<TreeNode>> levels = new ArrayList<>();

    public void levelOrder(TreeNode root, int level) {
        if (level == levels.size()) {
            levels.add(new ArrayList<>());
        }
        levels.get(level).add(root);

        if (root.left != null) {
            levelOrder(root.left, level + 1);
        }
        if (root.right != null) {
            levelOrder(root.right, level + 1);
        }
    }


}