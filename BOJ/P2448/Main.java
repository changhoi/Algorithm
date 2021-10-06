package P2448;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    static char[][] map;

    static void make(int r, int c) {
        for (int i = 0; i < 5; i++) map[r][c + i] = '*';
        map[r - 1][c + 1] = map[r - 1][c + 3] = '*';
        map[r - 2][c + 2] = '*';
    }

    static void draw(int n, int r, int c) {
        if (n == 3) {
            make(r, c);
            return;
        }

        int next = n / 2;
        draw(next, r, c);
        draw(next, r - next, c + next);
        draw(next, r, c + n);
    }

    static void print(int n) {
        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            char[] line = map[i];
            StringBuilder sb = new StringBuilder();
            for (char l : line) {
                if (l == '*') sb.append(l);
                else sb.append(" ");
            }
            if (i == n) {
                ans.append(sb.toString().trim());
            } else {
                ans.append(sb.append("\n"));
            }
        }
        System.out.print(ans);
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2448/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new char[n + 1][2 * n + 1];

        draw(n, n, 0);
        print(n);
    }
}
