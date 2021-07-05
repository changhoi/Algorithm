package P3055;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] direction = new int[][]{
            {1, 0},     // 우
            {0, 1},     // 하
            {-1, 0},    // 좌
            {0, -1}     // 상
    };
    static int R,C;

    static char[][] map;

    static int[] D = new int[2];
    static int[] S = new int[2];
    static List<int[]> waters = new ArrayList<>();
    static List<int[]> path = new ArrayList<>();
    static boolean invalid(int[] next) {
        return next[0] < 0 || next[0] >= R || next[1] < 0 || next[1] >= C;
    }

    static void printMap() {
        for (char[] l : map) {
            System.out.println(String.valueOf(l));
        }
    }

    static void solution() {
        int ans = 0;
        while (true) {
            List<int[]> nextWaters = new ArrayList<>();
            for (int[] w : waters) {
                for(int[]d : direction) {
                    int[] next = new int[]{w[0] + d[0], w[1] + d[1]};
                    if (invalid(next)) continue;
                    char obj = map[next[0]][next[1]];
                    if (obj == '*') continue;
                    if (obj == 'X') continue;
                    if (obj == 'D') continue;
                    map[next[0]][next[1]] = '*';
                    nextWaters.add(next);
                }
            }
            waters = nextWaters;

            List<int[]> nextPath = new ArrayList<>();
            for (int[] p : path) {
                for(int[]d : direction) {
                    int[] next = new int[]{p[0] + d[0], p[1] + d[1]};

                    if (invalid(next)) continue;
                    char obj = map[next[0]][next[1]];
                    if (obj == '*') continue;
                    if (obj == 'X') continue;
                    if (obj == 'S') continue;
                    if (obj == 'D') {
                        System.out.println(ans + 1);
                        return;
                    }
                    map[next[0]][next[1]] = 'S';
                    nextPath.add(next);
                }
            }
            printMap();
            System.out.println();

            if (nextPath.isEmpty()) {
                System.out.println("KAKTUS");
                return;
            } else {
                ans++;
                path = nextPath;
            }
        }



    }


    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P3055/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            char[] line = br.readLine().toCharArray();
            map[i] = line;
            for (int j = 0; j < line.length; j++) {
                char c = line[j];
                int[]point = new int[]{i, j};
                if (c == 'D') {
                    D = point;
                } else if (c == '*') {
                    waters.add(point);

                } else if (c == 'S') {
                    path.add(point);
                    S = point;
                }
            }
        }

        solution();
    }
}
