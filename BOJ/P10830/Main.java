package P10830;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] multiply(int[][] m1, int[][] m2, int n) {
        int[][] ret = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    ret[i][j] += m1[i][k] * m2[k][j];
                    ret[i][j] %= 1000;
                }
            }
        }

        return ret;
    }

    static void print(int[][] m) {
        for (int[] line : m) {
            StringBuilder sb = new StringBuilder();
            for (int i : line) sb.append(i).append(" ");
            System.out.println(sb.toString().trim());
        }
    }

    static int[][] solution(int[][] m, int n, long b) {
        if (b == 1) return m;
        long mid = b / 2;
        int[][] square = solution(m, n, mid);
        int[][] half = multiply(square, square, n);
        if (b % 2 == 1) return multiply(half, m, n);
        else return half;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P10830/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int[][] matrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) matrix[i][j] = Integer.parseInt(st.nextToken());
        }

        if (B == 1) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    matrix[i][j] %= 1000;
                }
            }
            print(matrix);
            return;
        }

        print(solution(matrix, N, B));
    }
}
