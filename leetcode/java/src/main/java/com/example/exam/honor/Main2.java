package com.example.exam.honor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        List<String> strings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            strings.add(in.nextLine());
        }

        List<String> solve = solve(strings);

        for (String s : solve) {
            System.out.println(s);
        }

    }

    private static List<String> solve(List<String> strings) {
        Set<String> set = new HashSet<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        for (String string : strings) {
            set.add(string);
        }
        List<String> list = new ArrayList<>(set);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {

                try {
                    String[] split1 = s1.split("/");
                    String[] split2 = s2.split("/");
                    Date time1 = sdf.parse(split1[1]);
                    Date time2 = sdf.parse(split2[1]);
                    if (time1.getTime() > time2.getTime()) {
                        return 1;
                    } else if (time1.getTime() < time2.getTime()) {
                        return -1;
                    } else {
                        if (s1.length() > s2.length()) {
                            return 1;
                        } else if (s1.length() < s2.length()) {
                            return -1;
                        } else {
                            if (split1[0].charAt(0) > split1[1].charAt(0)) {
                                return 1;
                            } else if (split1[0].charAt(0) < split1[1].charAt(0)) {
                                return -1;
                            } else {
                                return 0;
                            }
                        }
                    }
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        return list;

    }
}
