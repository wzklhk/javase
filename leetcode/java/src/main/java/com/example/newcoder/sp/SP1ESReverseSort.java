package com.example.newcoder.sp;

import java.util.ArrayList;

/**
 * 某云ES的文件管理系统中，文档由一个int型的ID和字符串类型的文档描述content组成，请根据提供的文档ID和文档描述，设计对搜索单词的倒排索引，根据输入要查找的单词，输出对应的文档ID。
 * <p>
 * 输入：[1, 5, 4, 9],["My lover", "Yours", "you are young", "My old age"],"My"
 * <p>
 * 返回值：[1,9]
 */

public class SP1ESReverseSort {
    public ArrayList<Integer> invertedIndex(ArrayList<Integer> ID, ArrayList<String> content, String word) {
        // write code here

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < content.size(); i++) {
            if (content.get(i).contains(word)) {
                result.add(ID.get(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s1 = "My lover";
        String s2 = "My";
        System.out.println(s1.contains(s2));
    }
}
