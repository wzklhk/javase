package com.example.newcoder.dji;

import java.util.ArrayList;
import java.util.List;

public class CompleteBinaryTreeSTraverse {

    public static List<Integer> traverse(int[] tree) {
        int length = tree.length;

        List<Integer> result = new ArrayList<>();
        boolean flag = true;

        int layerNum = 0;

        while ((int) Math.pow(2, layerNum) < length) {
            if (flag) {
                for (int i = (int) Math.pow(2, layerNum); i <= (int) Math.pow(2, layerNum + 1); i++) {
                    result.add(tree[i]);
                }
            } else {
                for (int i = (int) Math.pow(2, layerNum+1); i >= (int) Math.pow(2, layerNum); i--) {
                    result.add(tree[i]);
                }
            }
            flag = !flag;
            layerNum++;
        }

        return result;

    }

    public static void main(String[] args) {
        int[] tree = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> traverse = traverse(tree);
        System.out.println(traverse);
    }


}
