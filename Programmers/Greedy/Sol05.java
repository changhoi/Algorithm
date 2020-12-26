package Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution05 {
    static boolean[][] edgeTable;

    static boolean[] visited;

    boolean dfs(int current, int target) {
        if (edgeTable[current][target]) return true;

        boolean find;

        for(int j = 0; j < edgeTable[current].length; j++) {
            if(edgeTable[current][j] && !visited[j]) {
                visited[j] = true;
                find = dfs(j, target);
                if (find) return true;
            }
        }

        return false;
    }

    public int solution(int n, int[][] costs) {
        PriorityQueue<int[]> p = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[2], o2[2]);
            }
        });
        p.addAll(Arrays.asList(costs));

        edgeTable = new boolean[n][n];

        int sum = 0;
        int edgeCount = 0;
        int size = p.size();
        for (int i = 0; i < size; i++) {
            int[]edge = p.poll();
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];

            if (edgeCount < n - 1) {
                // 미완 상태이다.
                visited = new boolean[n];
                boolean reachable = dfs(from, to);

                if (!reachable) {
                    edgeTable[from][to] = edgeTable[to][from] = true;
                    sum += cost;
                }
            }
        }

        return sum;
    }
}
