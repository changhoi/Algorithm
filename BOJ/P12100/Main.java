package P12100;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    static int N;
    static int ans = 0;
    static Queue<Integer> q = new LinkedList<>();

    static void merge(int x, int y, int dx, int dy, int[][]b) {
        int cx = x; int cy = y;

        while(!q.isEmpty()) {
            int val = q.poll();
            if (b[cy][cx] == val) {
                b[cy][cx] += val;
                cx += dx; cy += dy;
            } else if (b[cy][cx] == 0){
                b[cy][cx] = val;
            } else {
                cx += dx; cy += dy;
                b[cy][cx] = val;
            }

        }
    }

    static void push(int val) {
        if (val != 0) {
            q.add(val);
        }
    }

    static void move(int k, int[][] b) {
        if (k == 0) {
            // 오른쪽
            for (int i = 0; i < N; i++) {
                for (int j = N - 1; j >= 0; j--) {
                    push(b[i][j]);
                    b[i][j] = 0;
                }
                merge(N - 1, i, -1, 0, b);
            }
        } else if (k == 1) {
            // 왼쪽
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    push(b[i][j]);
                    b[i][j] = 0;
                }
                merge(0, i, 1, 0, b);
            }
        } else if (k == 2) {
            // 위
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    push(b[j][i]);
                    b[j][i] = 0;
                }
                merge(i, 0, 0, 1, b);
            }
        } else {
            // 아래
            for (int i = 0; i < N; i++) {
                for (int j = N - 1; j >= 0; j--) {
                    push(b[j][i]);
                    b[j][i] = 0;
                }
                merge(i, N - 1, 0, -1, b);
            }
        }
    }
    static int getMax (int[][]b) {
        int ret = 0;
        for(int[] l: b) {
            for (int i: l) {
                ret = Math.max(ret, i);
            }
        }

        return ret;
    }

    static int[][] capture(int[][] b) {
        int[][] ret = new int[N][N];
        for(int i = 0; i < N; i++) {
            System.arraycopy(b[i], 0, ret[i], 0, N);
        }

        return ret;
    }

    static void game(int depth, int[][] b) {
        if (depth == 5) {
            ans = Math.max(getMax(b), ans);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int[][] captured = capture(b);
            move(i, captured);
            game(depth + 1, captured);
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P12100/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int [][] board = new int[N][];
        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        game(0, board);

        System.out.println(ans);
    }
}
