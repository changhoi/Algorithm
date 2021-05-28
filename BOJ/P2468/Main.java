package P2468;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

    static int[][] map;
    static int maxZone = Integer.MIN_VALUE;


    static void zone(boolean[][] contain, int x, int y, int rain) {
        contain[x][y] = true;
        int[][] direction = {
                {1, 0},
                {-1, 0},
                {0, -1},
                {0, 1}
        };

        for (int[] d: direction) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (map[nx][ny] == -1 || map[nx][ny] <= rain) continue;
            if (contain[nx][ny]) continue;

            zone(contain, nx, ny, rain);
        }
    }

    static int flood(int rain) {
        int ans = 0;
        boolean[][] contain = new boolean[N + 2][N + 2];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] <= rain || contain[i][j]) continue;
                zone(contain, i, j, rain);
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2468/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N + 2][N + 2];

        for (int i = 0; i < N + 2; i++) {
            map[i][0] = map[0][i] = map[N + 1][i] = map[i][N + 1] = -1;
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int val = Integer.parseInt(st.nextToken());
                map[i][j] = val;
                max = Math.max(max, val);
                min = Math.min(min, val);
            }
        }

        for (int i = min - 1; i <= max; i++) {
            int zone = flood(i);
            maxZone = Math.max(zone, maxZone);
        }

        System.out.println(maxZone);
    }

    static void printZone(boolean[][] zones) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0 ; j < N; j++) {
                if (zones[i][j]) sb.append("O");
                else sb.append("X");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
