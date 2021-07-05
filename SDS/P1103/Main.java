package P1103;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][]board;
    static boolean[][]visited;
    static int[][]dp;
    static int N, M;

    static int[][] directions = new int[][]{
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1},
    };

    public static int explore(int[] coin) {
        int cx = coin[1], cy = coin[0];

        if (dp[cy][cx] != 0) return dp[cy][cx];



        int x = board[cy][cx];
        visited[cy][cx] = true;

        int max = 0;
        for (int[] d : directions) {
            int dy = cy + d[0] * x;
            int dx = cx + d[1] * x;
            int[] next = new int[]{dy, dx};
            if (dx < 0 || dx >= M || dy < 0 || dy >= N) continue;
            if (board[dy][dx] == 0) continue;
            if (visited[dy][dx]) return -1;

            int val = explore(next);
            if (val == -1) return val;
            max = Math.max(val, max);
        }
        visited[cy][cx] = false;
        dp[cy][cx] = max + 1;
        return 1 + max;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1103/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            char[] str = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (str[j] != 'H') board[i][j] = str[j] - '0';
            }
        }

        int[] coin = new int[]{0, 0};
        System.out.println(explore(coin));
    }
}
