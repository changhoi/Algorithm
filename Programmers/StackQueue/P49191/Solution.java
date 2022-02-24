import java.util.*;

class Solution {
    boolean[][][] table;
    int[] recordCnt;

    void update(int curr, int n, int kind, boolean[][] currTable) {
        boolean[] checked = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        boolean[] t = currTable[kind];

        for (int i = 0; i < n; i++) {
            if (t[i]) {
                checked[i] = true;
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int next = queue.poll();
            t[next] = true;
            recordCnt[curr]++;

            boolean[] nt = table[next][kind];
            for (int i = 0; i < n; i++) {
                if (nt[i] && !checked[i]) {
                    queue.add(i);
                    checked[i] = true;
                }
            }
        }
    }

    public int solution(int n, int[][] results) {
        table = new boolean[n][2][n];
        recordCnt = new int[n];

        for (int[] r : results) {
            int w = r[0] - 1;
            int l = r[1] - 1;
            table[w][0][l] = true;
            table[l][1][w] = true;
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            boolean[][] personalTable = table[i];

            update(i, n, 0, personalTable);
            update(i, n, 1, personalTable);
            if (recordCnt[i] == n - 1) {
                ans++;
            }
        }


        return ans;
    }
}