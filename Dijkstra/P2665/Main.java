package P2665;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int[][] directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0},
    };

    static boolean isValid(int n, int r, int c) {
        return 0 <= r && r < n && 0 <= c && c < n;
    }

    static int[] getMin(Set<Integer> set, int[][] cost) {

        int ret = -1, min = Integer.MAX_VALUE;
        for (int s : set) {
            int r = s / 100;
            int c = s % 100;
            if (min > cost[r][c]) {
                min = cost[r][c];
                ret = s;
            }
        }

        set.remove(ret);

        return new int[]{ret/100, ret%100};
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2665/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        int[][] cost = new int[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0' == 0 ? 1 : 0;
                cost[i][j] = Integer.MAX_VALUE;
            }
        }

        cost[0][0] = 0;
        Set<Integer> set = new HashSet<>();
        set.add(0);
        boolean[][] visited = new boolean[n][n];

        while (!set.isEmpty()) {
            int[] p = getMin(set, cost);
            for (int[] d : directions) {
                int dy = p[0] + d[0];
                int dx = p[1] + d[1];
                if (!isValid(n, dy, dx) || visited[dy][dx]) continue;
                int c = cost[p[0]][p[1]] + map[dy][dx];
                if (cost[dy][dx] > c) {
                    set.add(dy*100+dx);
                    cost[dy][dx] = c;
                }
            }
            visited[p[0]][p[1]] = true;

        }
        System.out.println(cost[n - 1][n - 1]);
    }
}
