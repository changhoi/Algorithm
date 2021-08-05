package P1992;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[][] map;

    static String check(int n, int xs, int xe, int ys, int ye) {
        if (n == 1) {
            return String.valueOf(map[ys][xs]);
        } else {
            int xMid  = (xs + xe) / 2;
            int yMid  = (ys + ye) / 2;
            String depth = check(n / 2, xs, xMid, ys, yMid);
            depth += check(n / 2, xMid, xe, ys, yMid);
            depth += check(n / 2, xs, xMid, yMid, ye);
            depth += check(n / 2, xMid, xe, yMid, ye);
            if (depth.equals("0000")) return "0";
            else if (depth.equals("1111")) return "1";
            else return "(" + depth + ")";
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1992/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) map[i][j] = line[j] - '0';
        }

        System.out.println(check(n, 0, n, 0, n));
    }
}
