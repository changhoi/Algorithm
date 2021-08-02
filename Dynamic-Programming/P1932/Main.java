package P1932;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][][] triangle;
    static int n;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1932/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        triangle = new int[n][][];
        int root = Integer.parseInt(br.readLine());
        triangle[0] = new int[][]{{root, root}};

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            triangle[i] = new int[i + 1][2];
            for (int j = 0; j < i + 1; j++) {
                triangle[i][j][0] = Integer.parseInt(st.nextToken());


                if (j == i) triangle[i][j][1] = triangle[i - 1][j - 1][1] + triangle[i][j][0];
                else if (j == 0) triangle[i][j][1] = triangle[i - 1][j][1] + triangle[i][j][0];
                else triangle[i][j][1] = Math.max(triangle[i - 1][j - 1][1], triangle[i - 1][j][1]) + triangle[i][j][0];
            }
        }
        int ans = 0;
        for (int[] val : triangle[n - 1]) ans = Math.max(ans, val[1]);
        System.out.println(ans);
    }
}
