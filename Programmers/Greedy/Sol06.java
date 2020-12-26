package Greedy;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] routes) {
        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        Collections.addAll(q, routes);
        int[] section = new int[]{-30000, 30000};
        int camera = 0;
        while(!q.isEmpty()) {
            int [] route = q.poll();
            if (route[0] > section[1]) {
                section = route;

                camera++;
            } else {
                if (section[0] < route[0]) {
                    section[0] = route[0];
                }

                if (section[1] > route[1]) {
                    section[1] = route[1];
                }
            }
        }
        return ++camera;
    }
}