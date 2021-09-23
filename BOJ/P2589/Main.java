package P2589;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, dist = Integer.MIN_VALUE;
    static boolean[][] map;
    static int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1},
    };

    static boolean isValid(int r, int c) {
        return 0 <= r && r < n && 0 <= c && c < m;
    }

    static void bfs(int r, int c) {
        boolean[][] visited = new boolean[n][m];
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> next = new LinkedList<>();
        int distance = 0;
        queue.add(r * 100 + c);
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int p = queue.poll();
            int y = p / 100;
            int x = p % 100;
            for (int[] d : directions) {
                int dy = y + d[0];
                int dx = x + d[1];
                if (!isValid(dy, dx) || visited[dy][dx] || !map[dy][dx]) continue;
                visited[dy][dx] = true;
                next.add(dy * 100 + dx);
            }

            if (queue.isEmpty()) {
                Queue<Integer> temp = queue;
                queue = next;
                next = temp;
                distance++;
            }
        }
        dist = Math.max(dist, distance - 1);
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2589/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j) - 'L' == 0;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!map[i][j]) continue;
                bfs(i, j);
            }
        }

        System.out.println(dist);
    }
}
