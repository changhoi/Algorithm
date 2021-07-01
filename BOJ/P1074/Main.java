package P1074;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1074/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());   // 세로
        int c = Integer.parseInt(st.nextToken());   // 가로

        int len = (int) Math.pow(2, N);
        int[] start = new int[]{0, 0};
        int[] end = new int[]{len - 1, len - 1};

        int depth = N;
        int cnt = 0;
        while (depth > 0) {
            int mul = (int) Math.pow(2, 2 * (depth - 1));
            int[] mid = new int[]{
                    (start[0] + end[0]) / 2,
                    (start[1] + end[1]) / 2,
            };

            if (c <= mid[0]) {
                // 1, 3
                if (r > mid[1]) {
                    // 3
                    end[0] = mid[0];
                    start[1] = mid[1] + 1;
                    cnt += 2 * mul;
                } else {
                    // 1
                    end[0] = mid[0];
                    end[1] = mid[1];
                }
            } else {
                if (r > mid[1]) {
                    // 4
                    start[0] = mid[0] + 1;
                    start[1] = mid[1] + 1;
                    cnt += 3 * mul;
                } else {
                    // 2
                    start[0] = mid[0] + 1;
                    end[1] = mid[1];
                    cnt += mul;
                }
            }
            depth--;
        }
        System.out.println(cnt);
    }
}
