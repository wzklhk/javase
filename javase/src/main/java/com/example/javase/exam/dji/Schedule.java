package com.example.javase.exam.dji;

import java.util.*;

/**
 * 任务调度
 * <p>
 * 输入一系列任务，每个任务参数分别为权重、开始时间、结束时间
 * <p>
 * 找到权重和最大的任务列表
 */

public class Schedule {
    /*public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        in.nextLine();

        List<List<Integer>> schedules = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> schedule = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                int nextInt = in.nextInt();
                schedule.add(nextInt);
            }
            schedule.add(i); // index
            schedules.add(schedule);
            in.nextLine();
        }
        List<Integer> result = schedule(schedules);

        System.out.println(result.get(0) + " " + result.get(1));

    }*/

    public static void main(String[] args) {
        int[][] schedulesArray = {
                {3, 0, 6},
                {1, 1, 4},
                {4, 3, 5},
                {17, 3, 8},
                {9, 4, 7},
                {10, 5, 9},
                {8, 6, 10},
                {1, 8, 11}
        };
        List<List<Integer>> schedules = new ArrayList<>();
        for (int i = 0; i < schedulesArray.length; i++) {
            List<Integer> schedule = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                schedule.add(schedulesArray[i][j]);
            }
            schedule.add(i); // index
            schedules.add(schedule);
        }
        List<Integer> result = schedule(schedules);
        for (int i = 0; i < result.size(); i++) {
            System.out.printf("%d", result.get(i));
            if (i == result.size() - 1) {
                System.out.printf("\n");
            } else {
                System.out.printf(" ");
            }
        }

    }

    public static List<Integer> schedule(List<List<Integer>> schedules) {
        List<Integer> result = new ArrayList<>();
        int n = schedules.size();
        Collections.sort(schedules, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o2.get(0) - o1.get(0);
            }
        });
        Map<Integer, Boolean> map = new HashMap();

        for (int i = schedules.get(0).get(1); i < schedules.get(0).get(2); i++) {
            map.put(i, true);
        }
        result.add(schedules.get(0).get(3));

        for (int i = 1; i < n; i++) {
            boolean flag = true;
            for (int j = schedules.get(i).get(1); j < schedules.get(i).get(2); j++) {
                if (map.getOrDefault(j, false)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                for (int j = schedules.get(i).get(1); j < schedules.get(i).get(2); j++) {
                    map.put(j, true);
                }
                result.add(schedules.get(i).get(3));
            }
        }

        return result;
    }
}
