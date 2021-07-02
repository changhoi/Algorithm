package P1149;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int getMin(int[] arr) {
        int min = 1001;
        for (int a : arr) {
            min = Math.min(a, min);
        }
        return min;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1149/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];

        int[][][] dp = new int[N][3][3];     // 전 단계에서 어딜 선택했는지에 따른 N이 가능한 최소값

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[1][0][1] = arr[0][0] + arr[1][1];
        dp[1][0][2] = arr[0][0] + arr[1][2];

        dp[1][1][0] = arr[0][1] + arr[1][0];
        dp[1][1][2] = arr[0][1] + arr[1][2];

        dp[1][2][0] = arr[0][2] + arr[1][0];
        dp[1][2][1] = arr[0][2] + arr[1][1];

        for (int i = 2; i < N; i++) {
            int min0 = Math.min(dp[i - 1][1][0], dp[i - 1][2][0]);
            int min1 = Math.min(dp[i - 1][0][1], dp[i - 1][2][1]);
            int min2 = Math.min(dp[i - 1][0][2], dp[i - 1][1][2]);

            dp[i][0][1] = min0 + arr[i][1];
            dp[i][0][2] = min0 + arr[i][2];

            dp[i][1][0] = min1 + arr[i][0];
            dp[i][1][2] = min1 + arr[i][2];

            dp[i][2][0] = min2 + arr[i][0];
            dp[i][2][1] = min2 + arr[i][1];
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int[] d : dp[N - 1]) {
            for (int v : d) {
                if (v != 0) queue.add(v);
            }
        }


        System.out.println(queue.peek());
    }
}
