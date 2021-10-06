package P4485;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[][] directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0},
    };

    static boolean isValid(int r, int c, int n) {
        return 0 <= r && r < n && 0 <= c && c < n;
    }

    static void solution(int pn, int n, int[][]map) {
        int[][] dist = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < n * n; i++) {
            int r = i / n;
            int c = i % n;
            dist[r][c] = Integer.MAX_VALUE;
        }

        dist[0][0] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> dist[a[0]][a[1]]));
        queue.add(new int[]{0, 0, 0});
        while(!queue.isEmpty()) {
            int[] p = queue.poll();

            for (int[] d : directions) {
                int dx = p[1] + d[1];
                int dy = p[0] + d[0];
                if(!isValid(dy, dx, n) || visited[dy][dx]) continue;
                if (dist[dy][dx] > dist[p[0]][p[1]] + map[dy][dx]) {
                    dist[dy][dx] = dist[p[0]][p[1]] + map[dy][dx];
                    queue.add(new int[]{dy, dx});
                }
            }
            visited[p[0]][p[1]] = true;
        }

        int cost = dist[n - 1][n - 1] + map[0][0];

        System.out.println("Problem " + pn + ": " + cost);
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P4485/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int problem = 1;
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            int[][] map = new int[n][n];

            for(int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) map[i][j] = Integer.parseInt(st.nextToken());
            }

            solution(problem, n, map);
            problem++;
        }
    }
}
