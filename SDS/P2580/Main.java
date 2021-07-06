package P2580;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] board = new int[9][9];
    static List<int[]> points = new ArrayList<>();

    static int[] scope(int xy) {
        int[] s = new int[2];
        if (xy < 3) {
            s[0] = 0;
            s[1] = 3;
        } else if (xy < 6) {
            s[0] = 3;
            s[1] = 6;
        } else {
            s[0] = 6;
            s[1] = 9;
        }
        return s;
    }

    static boolean[] check(int[] p) {
        int y = p[0], x = p[1];
        boolean[] used = new boolean[9];
        for (int i = 0; i < 9; i++) {
            if (board[y][i] != 0) used[board[y][i] - 1] = true;
            if (board[i][x] != 0) used[board[i][x] - 1] = true;
        }

        int[] scopeX = scope(x);
        int[] scopeY = scope(y);
        for (int i = scopeY[0]; i < scopeY[1]; i++) {
            for (int j = scopeX[0]; j < scopeX[1]; j++) {
                if (board[i][j] != 0) used[board[i][j] - 1] = true;
            }
        }
        return used;
    }

    static boolean dfs(int idx) {
        if (idx == points.size()) {
            print();
            return true;
        }
        int[] p = points.get(idx);
        boolean[] used = check(p);

        for (int i = 0; i < 9; i++) {
            if (!used[i]) {
                board[p[0]][p[1]] = i + 1;
                boolean end = dfs(idx + 1);
                if (end) return true;
                board[p[0]][p[1]] = 0;
            }
        }
        return false;
    }

    static void print() {

        for (int[] line : board) {
            StringBuilder sb = new StringBuilder();
            for (int i : line) sb.append(i).append(" ");
            System.out.println(sb.toString().trim());
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2580/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) points.add(new int[]{i, j});
            }
        }

        dfs(0);
    }
}
