package P1780;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] answer = new int[3];

    static void check(int r, int c, int n, int[][] arr) {
        int inside = arr[r][c];
        boolean piece = false;
        for (int i = r; i < r+n; i++) {
            for (int j = c; j < c+n; j++) {
                if (arr[i][j] != inside) {
                    piece = true;
                    break;
                }
            }
        }

        if (!piece) {
            answer[inside]++;
            return;
        }

        int next = n / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                check(r+i*next, c+j*next, next, arr);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1780/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) + 1;
            }
        }

        check(0, 0, n, arr);
        for (int a : answer) System.out.println(a);
    }
}
