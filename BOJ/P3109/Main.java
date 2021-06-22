package P3109;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] map;
    static int[][] direction = {
            {1, -1},
            {1, 0},
            {1, 1}
    };

    static int dfs(int x, int y) {
        map[y][x] = 'x';
        if (x == C - 1) return 1;
        for (int[] d: direction) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (ny >= R || ny < 0 || map[ny][nx] == 'x') continue;
            if (dfs(nx, ny) == 1) return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P3109/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int cnt = 0;
        for (int i = 0; i < R; i++) {
            cnt += dfs(0, i);
        }
        System.out.println(cnt);
    }
}
