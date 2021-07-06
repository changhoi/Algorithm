package P2096;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][][] dp;

    static void setDp(int floor, int idx, int val) {
        int[][] f = dp[floor];
        if (floor == 0) {
            f[idx][0] = f[idx][1] = val;
            return;
        }

        int[][] u = dp[floor - 1];


        int idx1 = idx + 1;
        int idx2 = idx - 1;

        if (idx1 < 3 && idx2 >= 0) {
            f[idx][0] = Math.max(Math.max(u[idx1][0], u[idx2][0]), u[idx][0]) + val;
            f[idx][1] = Math.min(Math.min(u[idx1][1], u[idx2][1]), u[idx][1]) + val;
        } else if (idx1 >= 3 && idx2 >= 0) {
            f[idx][0] = Math.max(u[idx2][0], u[idx][0]) + val;
            f[idx][1] = Math.min(u[idx2][1], u[idx][1]) + val;
        } else if (idx1 < 3) {
            f[idx][0] = Math.max(u[idx1][0], u[idx][0]) + val;
            f[idx][1] = Math.min(u[idx1][1], u[idx][1]) + val;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2096/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new int[N][3][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());
            int i3 = Integer.parseInt(st.nextToken());
            setDp(i, 0, i1);
            setDp(i, 1, i2);
            setDp(i, 2, i3);
        }

        int[][] ans = dp[N - 1];
        int max = Math.max(Math.max(ans[0][0], ans[1][0]), ans[2][0]);
        int min = Math.min(Math.min(ans[0][1], ans[1][1]), ans[2][1]);

        System.out.println(max + " " + min);
    }
}
