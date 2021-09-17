package P10942;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static boolean[][] dp = new boolean[2002][2002];
    static int[] arr = new int[2002];

    public static void setDp() {

        for (int i = 1; i <= n; i++) {
            dp[i][i] = true;
            dp[i][i + 1] = arr[i] == arr[i + 1];
        }

        for (int sz = 3; sz <= n; sz++) {
            for (int i = 1; i <= n - sz + 1; i++)
                dp[i][i + sz - 1] = ((dp[i + 1][i + sz - 2]) && (arr[i] == arr[i + sz - 1]));
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P10942/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());
        setDp();

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            sb.append(dp[from][to] ? 1 : 0).append("\n");
        }
        System.out.println(sb);
    }
}
