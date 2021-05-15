package BOJ.BOJ1103;

import java.io.*;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static char[][] arr;
    static int count = 0;
    static boolean[][] visited;
    static int[][] dp;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static void dfs(int x, int y, int depth) {
        if (count == -1) return;
        count = Math.max(depth, count);
        dp[y][x] = depth;

        int val = arr[y][x] - '0';
        for (int i =0; i < 4; i++) {
            int newX = dx[i] * val + x;
            int newY = dy[i] * val + y;
            if (newX >= N || newX < 0 || newY < 0 || newY >= M || arr[newY][newX] == 'H') continue;
            if (visited[newY][newX]) {
                count = -1;
                return;
            }

            if (dp[newY][newX] > depth) continue;

            visited[newY][newX] = true;
            dfs(newX, newY, depth + 1);
            visited[newY][newX] = false;
        }



    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BOJ/BOJ1103/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new char[M][N];
        visited = new boolean[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            char[] carr = str.toCharArray();
            if (N >= 0) System.arraycopy(carr, 0, arr[i], 0, N);
        }

        visited[0][0] = true;
        dfs(0, 0, 1);
        System.out.println(count);
    }
}
