package P15686;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    int r, c;

    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public String toString() {
        return "Point{" +
                "r=" + r +
                ", c=" + c +
                '}';
    }
}

public class Main {
    static int N, M;
    static List<Point> houses = new ArrayList<>();
    static List<Point> chicken = new ArrayList<>();
    static int[][] vector;
    static boolean[] chosen;
    static int totalDist = Integer.MAX_VALUE;


    public static int operation(Point p1, Point p2) {
        return Math.abs(p1.r - p2.r) + Math.abs(p1.c - p2.c);
    }

    public static void updateDist() {
        int[] chickenDist = new int[houses.size()];
        for (int i = 0; i < chicken.size(); i++) {
            if (!chosen[i]) continue;
            for (int j = 0; j < houses.size(); j++) {
                if (chickenDist[j] == 0) {
                    chickenDist[j] = vector[j][i];
                } else {
                    chickenDist[j] = Math.min(vector[j][i], chickenDist[j]);
                }
            }
        }

        int tmp = 0;
        for (int d: chickenDist) {
            tmp += d;
        }
        totalDist = Math.min(totalDist, tmp);
    }

    public static void combination(int idx, int cnt) {
        if (cnt == M) {
            updateDist();
            return;
        }

        for (int i = idx; i < chicken.size(); i++) {
            if (chosen[i]) continue;
            chosen[i] = true;
            combination(idx + 1, cnt + 1);
            chosen[i] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P15686/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 1) {
                    houses.add(new Point(i, j));
                } else if (val == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }
        chosen = new boolean[chicken.size()];
        vector = new int[houses.size()][chicken.size()];
        for (int i = 0; i < houses.size(); i++) {
            for (int j = 0; j < chicken.size(); j++){
                vector[i][j] = operation(houses.get(i), chicken.get(j));
            }
        }
        combination(0, 0);
        System.out.println(totalDist);
    }
}
