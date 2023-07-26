package com.example.newcoder.meituan;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 小美和小团所在公司的食堂有N张餐桌，从左到右摆成一排，每张餐桌有2张餐椅供至多2人用餐，公司职员排队进入食堂用餐。小美发现职员用餐的一个规律并告诉小团：当男职员进入食堂时，他会优先选择已经坐有1人的餐桌用餐，只有当每张餐桌要么空着要么坐满2人时，他才会考虑空着的餐桌；
 * <p>
 * 当女职员进入食堂时，她会优先选择未坐人的餐桌用餐，只有当每张餐桌都坐有至少1人时，她才会考虑已经坐有1人的餐桌；
 * <p>
 * 无论男女，当有多张餐桌供职员选择时，他会选择最靠左的餐桌用餐。现在食堂内已有若干人在用餐，另外M个人正排队进入食堂，小团会根据小美告诉他的规律预测排队的每个人分别会坐哪张餐桌。
 */

public class Main3Canteen {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int length = Integer.parseInt(in.nextLine());
        for (int i = 0; i < length; i++) {
            String n = in.nextLine();
            String ns = in.nextLine();
            String m = in.nextLine();
            String ms = in.nextLine();

            Integer[] ni = new Integer[ns.length()];
            for (int i1 = 0; i1 < ni.length; i1++) {
                ni[i1] = ns.charAt(i1) - '0';
            }
            Character[] mc = new Character[ms.length()];
            for (int i1 = 0; i1 < mc.length; i1++) {
                mc[i1] = ms.charAt(i1);
            }


            List<Integer> solve = solve(ni, mc);
            for (Integer integer : solve) {
                System.out.println(integer);
            }

        }
    }

    private static List<Integer> solve(Integer[] seats, Character[] people) {
        int n = seats.length;

        List<Integer> result = new ArrayList<>();
        for (Character character : people) {
            if (character.equals('M')) {
                boolean flag = false;
                for (int i = 0; i < n; i++) {
                    if (seats[i] == 1) {
                        seats[i]++;
                        result.add(i + 1);
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    for (int i = 0; i < n; i++) {
                        if (seats[i] == 0) {
                            seats[i]++;
                            result.add(i + 1);
                            flag = true;
                            break;
                        }
                    }
                }
            } else {
                boolean flag = false;
                for (int i = 0; i < n; i++) {
                    if (seats[i] == 0) {
                        seats[i]++;
                        result.add(i + 1);
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    for (int i = 0; i < n; i++) {
                        if (seats[i] == 1) {
                            seats[i]++;
                            result.add(i + 1);
                            flag = true;
                            break;
                        }
                    }
                }
            }
        }

        return result;
    }
}
