package P1806;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int ans, N, S, start = 0, end = 0;
    static int[] arr;

    public static int getLen() {
        return end - start + 1;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1806/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        ans = N + 1;

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int v = arr[0];
        while (end < N) {
            if (v >= S) {
                ans = Math.min(getLen(), ans);
                v -= arr[start++];
            } else {
                if (end + 1 < N) v += arr[++end];
                else break;
            }
        }
        if (ans == N + 1) System.out.println(0);
        else System.out.println(ans);
    }
}
