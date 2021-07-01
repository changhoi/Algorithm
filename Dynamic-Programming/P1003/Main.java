package P1003;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class DP {
    int zero;
    int one;

    public DP(int zero, int one) {
        this.zero = zero;
        this.one = one;
    }

    @Override
    public String toString() {
        return zero + " " + one;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1003/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        DP[] dp = new DP[41];
        dp[0] = new DP(1, 0);
        dp[1] = new DP(0, 1);

        for (int i = 2; i <=40; i++) {
            dp[i] = new DP(dp[i - 1].zero + dp[i - 2].zero, dp[i - 1].one + dp[i - 2].one);
        }

        for (int i = 0; i < T; i++) {
            int val = Integer.parseInt(br.readLine());
            System.out.println(dp[val]);
        }
    }
}
