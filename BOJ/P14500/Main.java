package P14500;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int[][] map;
    public static int[][][] shape = {
            {{0, 0}, {0, 1}, {1, 0}, {1, 1}}, // ㅁ
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}}, // ㅡ
            {{0, 0}, {1, 0}, {2, 0}, {3, 0}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 0}}, // ㄴ
            {{0, 2}, {1, 0}, {1, 1}, {1, 2}},
            {{0, 0}, {1, 0}, {1, 1}, {1, 2}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 2}},
            {{0, 0}, {1, 0}, {2, 0}, {2, 1}},
            {{0, 0}, {0, 1}, {1, 1}, {2, 1}},
            {{0, 0}, {0, 1}, {1, 0}, {2, 0}},
            {{0, 1}, {1, 1}, {2, 0}, {2, 1}},
            {{0, 0}, {1, 0}, {1, 1}, {2, 1}}, // Z
            {{0, 1}, {1, 0}, {1, 1}, {2, 0}},
            {{0, 1}, {0, 2}, {1, 0}, {1, 1}},
            {{0, 0}, {0, 1}, {1, 1}, {1, 2}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 1}}, // ㅗ
            {{0, 1}, {1, 0}, {1, 1}, {1, 2}},
            {{0, 1}, {1, 0}, {1, 1}, {2, 1}},
            {{0, 0}, {1, 0}, {1, 1}, {2, 0}}
    };

    public static int travel(int x, int y) {
        int max = 0;
        for (int[][] points : shape) {
            int val = 0;
            for (int[] p : points) {
                int nx = p[1] + x;
                int ny = p[0] + y;
                if (nx >= N || ny >= M) {
                    val = 0;
                    break;
                }
                val += map[nx][ny];
            }
            max = Math.max(max, val);
        }

        return max;
    }

    public static void solve() {
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                max = Math.max(travel(i, j), max);
            }
        }

        System.out.println(max);
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P14500/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();
    }
}
