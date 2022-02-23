package P43238;

import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<Integer>[] nodes = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int[] e : edge) {
            int a = e[0] - 1;
            int b = e[1] - 1;
            nodes[a].add(b);
            nodes[b].add(a);
        }

        boolean[] checked = new boolean[n];

        int v = 0;
        checked[v] = true;

        Queue<Integer> queue = new LinkedList<>();
        for (int to : nodes[v]) {
            queue.add(to);
            checked[to] = true;
        }

        while(true) {
            Queue<Integer> newQueue = new LinkedList<>();

            int before = queue.size();

            while(!queue.isEmpty()) {

                int next = queue.poll();

                for (int to : nodes[next]) {
                    if(checked[to]) continue;
                    checked[to] = true;
                    newQueue.add(to);
                }
            }

            if (newQueue.isEmpty()) return before;

            queue = newQueue;
        }
    }
}