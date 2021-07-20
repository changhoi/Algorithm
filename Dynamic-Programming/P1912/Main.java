package P1912;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    static int n;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1912/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) dp[i] = Integer.parseInt(st.nextToken());

        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + dp[i], dp[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
