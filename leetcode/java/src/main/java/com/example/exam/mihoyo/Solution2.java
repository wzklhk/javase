package com.example.exam.mihoyo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


public class Solution2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param scores int整型ArrayList
     * @return string字符串ArrayList
     */
    public ArrayList<String> validResult(ArrayList<Integer> scores) {
        // write code here

        RankingList rank = new RankingList();
        for (int i = 0; i < scores.size(); i++) {
            rank.put("UID-00" + i + 1, scores.get(i));
        }


        return rank.getUserCodesByScoreScope(0, 100);
    }
}

class RankingList {

    private Map<String, Integer> map = new HashMap<>();

    public void put(String userCode, int score) {
        map.put(userCode, score);
    }

    public ArrayList<String> getUserCodesByScoreScope(int minScore, int maxScore) {
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (minScore <= entry.getValue() && entry.getValue() <= maxScore) {
                list.add(entry);
            }
        }

        Collections.sort(list, (o1, o2) -> o1.getValue() - o2.getValue());

        ArrayList<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : list) {
            result.add(entry.getKey());
        }

        if (result.size() != 0) {
            return result;
        } else {
            return null;
        }
    }
}