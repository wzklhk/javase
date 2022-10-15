package com.example.javase.exam.qunaer;

import org.junit.Test;

import java.util.*;

public class Main3 {
    public String showDown(String inHand) {
        String[] split = inHand.split(" ");

        for (int i = 0; i < split.length; i++) {
            String s = split[i];

            if (s.charAt(1) == 'A') {
                StringBuilder sb = new StringBuilder();
                sb.append(s.charAt(0));
                sb.append("1");
                split[i] = sb.toString();
            } else if (s.charAt(1) == 'K') {
                StringBuilder sb = new StringBuilder();
                sb.append(s.charAt(0));
                sb.append("13");
                split[i] = sb.toString();
            } else if (s.charAt(1) == 'Q') {
                StringBuilder sb = new StringBuilder();
                sb.append(s.charAt(0));
                sb.append("12");
                split[i] = sb.toString();
            } else if (s.charAt(1) == 'J') {
                StringBuilder sb = new StringBuilder();
                sb.append(s.charAt(0));
                sb.append("11");
                split[i] = sb.toString();
            }
        }

        Arrays.sort(split);

        Map<Character, Integer> typeMap = new HashMap<>();
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < split.length; i++) {
            char type = split[i].charAt(0);
            typeMap.put(type, typeMap.getOrDefault(type, 0) + 1);
            int num = Integer.parseInt(split[i].substring(1));
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : typeMap.entrySet()) {
            if (entry.getValue() >= 5) {
                Character key = entry.getKey();
                List<Integer> nums = new ArrayList<>();
                for (String s : split) {
                    if (s.charAt(0) == key) {
                        nums.add(Integer.parseInt(s.substring(1)));
                    }
                }
                Collections.sort(nums);

                boolean isAce = nums.get(0) == 1;
                if (isAce == false) {
                    for (int i = 1; i < nums.size(); i++) {
                        if (nums.get(i) - nums.get(i - 1) != 1) {
                            return "TongHua";
                        }
                        return "TongHuaShun";
                    }
                } else {
                    int n = nums.size();
                    if (nums.get(n - 1) == 13 &&
                            nums.get(n - 2) == 12 &&
                            nums.get(n - 3) == 11 &&
                            nums.get(n - 4) == 10) {
                        return "HuangJiaTongHuaShun";
                    }
                }
                return "TongHua";
            }
        }

        int have3 = 0;
        int have2 = 0;
        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            if (entry.getValue() == 4) {
                return "SiTiao";
            } else if (entry.getValue() == 3) {
                have3++;
            } else if (entry.getValue() == 2)
                have2++;
        }

        if (have3 >= 1 && have2 >= 1) {
            return "HuLu";
        } else if (have3 >= 1 && have2 == 0) {
            return "SanTiao";
        } else if (have3 == 0 && have2 >= 2) {
            return "LiangDui";
        } else if (have3 == 0 && have2 == 1) {
            return "YiDui";
        }

        return "ShunZi";
    }

    @Test
    public void test() {
        System.out.println(showDown("SA SK H10 SQ SJ S10 C9"));
    }
}
