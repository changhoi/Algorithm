package P1987;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] map;
    static boolean[] alphabets;
    static boolean[][] visited;
    static int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    static boolean isValid(int x, int y) {
        return 0 <= x && x < C && 0 <= y && y < R;
    }

    static int dfs(int depth, int x, int y) {
        char c = map[y][x];
        visited[y][x] = true;
        alphabets[c - 'A'] = true;
        int max = depth;
        for (int[] d : directions) {
            int dx = x + d[0];
            int dy = y + d[1];
            if (!isValid(dx, dy)) continue;
            if (visited[dy][dx] || alphabets[map[dy][dx] - 'A']) continue;

            max = Math.max(dfs(depth + 1, dx, dy), max);
        }

        visited[y][x] = false;
        alphabets[c - 'A'] = false;

        return max;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1987/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        alphabets = new boolean[26];

        for (int i = 0; i < R; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = chars[j];
            }
        }

        System.out.println(dfs(1, 0, 0));
    }
}
