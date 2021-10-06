package P2630;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] ans = new int[2];

    static void check(int r, int c, int n, int[][] arr) {
        int inside = arr[r][c];
        boolean unity = true;

        for (int i = r; i < r+n; i++) {
            for(int j = c; j < c+n;j++) {
                if(inside != arr[i][j]) {
                    unity = false;
                    break;
                }
            }
            if (!unity) break;
        }

        int next = n / 2;

        if (unity) {
            ans[inside]++;
            return;
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                check(r+i*next, c +j*next, next, arr);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2630/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        check(0, 0, n, arr);

        for (int a : ans) System.out.println(a);
    }
}
