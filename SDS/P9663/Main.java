package P9663;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] map;
    static int N;
    static int ans;

    static boolean check(int line, int x) {
        for (int i = 0; i < line; i++) {
            int occupied = map[i];
            if (occupied == 0) continue;
            if (occupied == x || x - (line - i) == occupied || x + (line - i) == occupied) return false;
        }
        return true;
    }

    static void occupy(int x, int y) {
        if (y == N - 1) {
            ans++;
            System.out.println(Arrays.toString(map));
            return;
        }

        map[y] = x;

        for (int i = 1; i <= N; i++) {
            if (check(y + 1, i)) occupy(i, y + 1);
        }
        map[y] = 0;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P9663/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];

        for (int i = 1; i <= N; i++) {
            occupy(i, 0);
        }

        System.out.println(ans);
    }
}
