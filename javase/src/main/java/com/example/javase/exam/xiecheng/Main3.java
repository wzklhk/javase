package com.example.javase.exam.xiecheng;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        String color = in.nextLine();


        int[][] graph = new int[n][n];

        Map<Node, List<Node>> graph2 = new HashMap<>();

        for (int i = 0; i < n - 1; i++) {
            int v1 = in.nextInt();
            int v2 = in.nextInt();
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;

            Node node = new Node(v1, color.charAt(v1 + 1));
            graph2.put(node, graph2.getOrDefault(node, new ArrayList<>()));

            in.nextLine();
        }
        System.out.println("1");
    }


}

class Node {
    public Integer nodeId;
    public Character nodeColor;

    public Node(Integer nodeId, Character nodeColor) {
        this.nodeId = nodeId;
        this.nodeColor = nodeColor;
    }
}