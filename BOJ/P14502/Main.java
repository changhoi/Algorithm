package P14502;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, max = 0;
    static int[][] map, directions = new int[][]{
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
    static List<int[]> virus = new ArrayList<>();

    static int[][] copyMap() {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) if (M >= 0) System.arraycopy(map[i], 0, copy[i], 0, M);

        return copy;
    }

    static boolean invalidPoint(int x, int y) {
        return x < 0 || x >= M || y < 0 || y >= N;
    }

    static int cntSpace(int[][] map) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

    static void solution(int cnt, int idx) {
        if (cnt < 3) {
            for (int i = idx; i < N * M; i++) {
                int x = i % M;
                int y = i / M;
                if (map[y][x] != 0) continue;
                map[y][x] = 1;
                solution(cnt + 1, i + 1);
                map[y][x] = 0;
            }
        } else {
            int[][] stage = copyMap();
            for (int[] p : virus) bfs(p, stage);
            max = Math.max(max, cntSpace(stage));
        }
    }


    static void bfs(int[] start, int[][] map) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int[] d : directions) {
                int dy = point[0] + d[0];
                int dx = point[1] + d[1];
                if (invalidPoint(dx, dy)) continue;
                if (map[dy][dx] != 0) continue;
                map[dy][dx] = 2;
                queue.add(new int[]{dy, dx});
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P14502/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int val = Integer.parseInt(st.nextToken());
                map[i][j] = val;
                if (val == 2) virus.add(new int[]{i, j});
            }
        }


        solution(0, 0);
        System.out.println(max);
    }

    static void print(int[][] map) {
        for (int[] line : map) System.out.println(Arrays.toString(line));
        System.out.println();
    }
}
