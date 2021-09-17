package P1799;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] arr;
    static int answer = 0, n;

    static boolean available(int r, int c, List<Integer> list) {
        for (int p : list) {
            if (Math.abs(p / n - r) == Math.abs(p % n - c)) return false;
        }

        return true;
    }

    static void putNext(int idx, int c, int cnt, List<Integer> list) {
        if (n % 2 == 0) {
            if (c == n - 1) put(idx + 1, cnt, list);
            else if (c == n - 2) put(idx + 3, cnt, list);
            else put(idx + 2, cnt, list);
        } else {
            put(idx + 2, cnt, list);
        }
    }

    static void put(int idx, int cnt, List<Integer> list) {
        if (idx >= n * n) {
            answer = Math.max(answer, cnt);
            return;
        }

        int r = idx / n;
        int c = idx % n;
        if (available(r, c, list) && arr[r][c]) {
            list.add(idx);
            putNext(idx, c, cnt + 1, list);
            list.remove((Integer) idx);
        }
        putNext(idx, c, cnt, list);
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1799/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) == 1;
            }
        }

        put(0, 0, new ArrayList<>());
        int even = answer;
        answer = 0;
        put(1, 0, new ArrayList<>());

        System.out.println(answer + even);
    }
}
