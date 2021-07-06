package P1072;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long getZ(long x, long y) {
        return 100 * y / x;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1072/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        long Z = getZ(X, Y);

        if (Z >= 99) {
            System.out.println(-1);
            return;
        }

        long l = 0, r = X;

        while (l < r) {
            long mid = (l + r) / 2;
            if (getZ(X + mid, Y + mid) > Z) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        System.out.println(l);
    }
}
