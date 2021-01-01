package DP;

import java.util.Arrays;

class Solution04 {
    public int solution(int[] money) {
        int len = money.length;

        int[][] dp = new int[len][2];
        if (len == 3) {
            return Math.max(money[0], Math.max(money[1], money[2]));
        }

        dp[0][1] = money[0];
        dp[1][0] = money[1];
        dp[1][1] = money[0];
        dp[2][0] = Math.max(money[2], dp[1][0]);
        dp[2][1] = money[0] + money[2];

        for(int i = 3; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], money[i] + dp[i - 2][0]);
            dp[i][1] = Math.max(dp[i - 1][1], money[i] + dp[i - 2][1]);
        }

        dp[len - 1][1] = 0;

        for(int[] i : dp) {
            System.out.println(Arrays.toString(i));
        }

        return Math.max(dp[len - 1][0], Math.max(dp[len - 2][0], dp[len - 2][1]));
    }
}

class WrongSolution {
    public int solution(int[] money) {
        int len = money.length;

        int[][] dp = new int[len][2];

        dp[0][1] = money[0];
        dp[1][0] = money[1];
        dp[2][1] = money[2] + dp[0][1];
        dp[2][0] = money[2];

        for(int i = 3; i < len; i++) {
            dp[i][0] = money[i] + Math.max(dp[i - 2][0], dp[i - 3][0]);
            dp[i][1] = money[i] + Math.max(dp[i - 2][1], dp[i - 3][1]);
        }

        dp[len - 1][1] = -1;

        for(int [] i : dp) {
            System.out.println(Arrays.toString(i));
        }

        return Math.max(dp[len - 1][0], Math.max(dp[len - 2][0], dp[len - 2][1]));
    }
}