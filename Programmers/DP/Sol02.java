package DP;

class Solution02 {
    int[][] dp;

    public int solution(int[][] triangle) {
        int floors = triangle.length;
        dp = new int[floors][floors];

        dp[0][0] = triangle[0][0];

        for (int i = 1; i < floors; i++) {
            for (int j = 0; j <= i; j++) {
                int left = j - 1;
                if (left >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][left], dp[i - 1][j]) + triangle[i][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                }
            }
        }

        int max = 0;
        for (int ans : dp[floors - 1]) {
            max = Math.max(max, ans);
        }

        return max;
    }
}