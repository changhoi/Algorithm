package Greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

class Edge {
    int from;
    int to;
    int cost;

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "{from: " + from + ", to: " + to + ", cost: " + cost + "}";
    }
}

class Solution02 {
    static boolean[] modified;
    static int len;

    int modifyChar (char to) {
        int toIdx = to - 'A';
        if (toIdx > 26 / 2) {
            return 26 - toIdx;
        } else {
            return toIdx;
        }
    }

    int getCost(int from, int to) {
        int min, max;
        if (from > to) {
            min = to;
            max = from;
        } else {
            min = from;
            max = to;
        }

        int forward = max - min;
        int backward = len - max + min;

        return Math.min(forward, backward);
    }

    public int solution(String name) {
        // 문제가 상당히 불완전함.
        char[] chars = name.toCharArray();
        len = chars.length;
        modified = new boolean[len];
        int controls = 0;

        for (int i = 0; i < len; i++) {
            if (chars[i] != 'A') {
                modified[i] = true;
                controls += modifyChar(chars[i]);
            }
        }

        int cursor = 0;
        while(true) {
            modified[cursor] = false;
            PriorityQueue<Edge> q = new PriorityQueue<>(new Comparator<Edge>() {
                @Override
                public int compare(Edge o1, Edge o2) {
                    return Integer.compare(o1.cost, o2.cost);
                }
            });

            Edge[] edges = new Edge[len];
            for (int i = 0; i < len; i++) {
                if (modified[i]) {
                    edges[i] = new Edge(cursor, i, getCost(cursor, i));
                    q.add(edges[i]);
                }
            }

            if (q.isEmpty()) break;

            Edge e = q.poll();
            cursor = e.to;
            controls += e.cost;
        }

        return controls;
    }
}