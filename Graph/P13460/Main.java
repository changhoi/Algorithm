package P13460;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][][][] visited;
    static int[] Rpoint = new int[2], Bpoint = new int[2];
    static int[][] directions = {
            {-1, 0},
            {0, 1},
            {0, -1},
            {1, 0},
    };

    static int[] move(int[] start, int[] d) {
        boolean marble = false;
        if (d[0] == 0) {
            for (int i = start[1] + d[1]; i < M && i >= 0; i += d[1]) {
                char c = map[start[0]][i];
                if (c == 'O') return null;
                if (c == '.') continue;
                if (c == 'B' || c == 'R') {
                    marble = true;
                    continue;
                }

                if (marble) return new int[]{start[0], i - (2 * d[1])};
                return new int[]{start[0], i - d[1]};
            }
        } else {
            for (int i = start[0] + d[0]; i < N && i >= 0; i += d[0]) {
                char c = map[i][start[1]];
                if (c == 'O') return null;
                if (c == '.') continue;
                if (c == 'B' || c == 'R') {
                    marble = true;
                    continue;
                }

                if (marble) return new int[]{i - (2 * d[0]), start[1]};
                return new int[]{i - d[0], start[1]};
            }
        }

        return start;
    }


    static void movePoint(int[] from, int[] to, char c) {
        map[from[0]][from[1]] = '.';
        map[to[0]][to[1]] = c;
    }


    static int game(int step, int[] red, int[] blue) {
        int min = Integer.MAX_VALUE;
        if (step == 10) return min;

        visited[red[0]][red[1]][blue[0]][blue[1]] = true;
        for (int[] d : directions) {

            int[] dred = move(red, d);
            int[] dblue = move(blue, d);

            if (dblue == null) continue;
            if (dred == null) {
                min = step + 1;
                break;
            }
            if (visited[dred[0]][dred[1]][dblue[0]][dblue[1]]) continue;
            movePoint(red, dred, 'R');
            movePoint(blue, dblue, 'B');
            min = Math.min(game(step + 1, dred, dblue), min);
            movePoint(dred, red, 'R');
            movePoint(dblue, blue, 'B');
        }
        visited[red[0]][red[1]][blue[0]][blue[1]] = false;
        return min;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M][N][M];
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = chars[j];
                if (chars[j] == 'R') {
                    Rpoint[0] = i;
                    Rpoint[1] = j;
                } else if (chars[j] == 'B') {
                    Bpoint[0] = i;
                    Bpoint[1] = j;
                }
            }
        }

        int ret = game(0, Rpoint, Bpoint);
        if (ret == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ret);
    }
}
