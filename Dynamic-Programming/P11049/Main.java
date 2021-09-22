package P11049;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] matrix = new int[502][2];
    static int[][] dp = new int[502][502]; // [i : 시작, k : 시작부터 현재 인덱스까지 연산 결과]

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P11049/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + (matrix[i][0] * matrix[k][1] * matrix[j][1]));
                }
            }
        }

        System.out.println(dp[1][n]);
    }
}
