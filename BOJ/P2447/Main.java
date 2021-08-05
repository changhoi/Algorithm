package P2447;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static void draw(int n, int i, int j) {
        if ((i / n) % 3 == 1 && (j / n) % 3 == 1)  sb.append(" ");
        else {
            if (n == 1) sb.append("*");
            else draw(n / 3, i, j);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                draw(N, i, j);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
