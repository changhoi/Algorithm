package DP;

class Solution03 {
    int DIVIDER = 1000000007;

    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n + 1][m + 1];
        boolean[][] sunkArea = new boolean[n + 1][m + 1];
        for (int[] sunk : puddles) sunkArea[sunk[1]][sunk[0]] = true;

        dp[1][1] =  1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1) continue;
                dp[i][j] = sunkArea[i][j] ? 0 : (dp[i - 1][j] + dp[i][j - 1]) % DIVIDER;
            }
        }

        return dp[n][m];
    }
}