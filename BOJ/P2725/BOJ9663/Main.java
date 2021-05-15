package BOJ.BOJ9663;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] table;
    static int count = 0;

    //행을 기준으로 열과 대각선을 확인
    static boolean check(int tuple) {
        for (int col = 0; col < tuple; col++) {
            if (table[tuple] == table[col] || Math.abs(table[tuple] - table[col]) ==  tuple - col ) {
                return false;
            }
        }
        return true;
    }

    static void dfs(int tuple) {
        if (tuple == N) {
            count += 1;
        }
        else {
            for (int col = 0; col < N; col++) {
                table[tuple] = col;
                if (check(tuple)) {
                    dfs(tuple+1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/BOJ/BOJ9663/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        table = new int[N];

        dfs(0);

        System.out.println(count);
    }
}
