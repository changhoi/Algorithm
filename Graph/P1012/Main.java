package P1012;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0},
    };

    static boolean isValid(int n, int m, int x, int y) {
        return 0 <= x && x < m && 0 <= y && y < n;
    }


    static void dfs(boolean[][]visited, int r, int c, int n, int m, boolean[][]map) {
        visited[r][c] = true;

        for (int[]d : directions) {
            int dy = r + d[0];
            int dx = c + d[1];
            if (isValid(n, m, dx, dy) && !visited[dy][dx] && map[dy][dx]) {
                dfs(visited, dy, dx, n, m, map);
            }
        }
    }

    static void solution(int r, int c, boolean[][] map) {
        boolean[][] visited = new boolean[r][c];

        int cnt = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(visited[i][j] || !map[i][j]) continue;
                cnt++;
                dfs(visited, i, j, r, c, map);
            }
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1012/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            boolean[][] map = new boolean[n][m];

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = true;
            }

            solution(n, m, map);
        }
    }
}
