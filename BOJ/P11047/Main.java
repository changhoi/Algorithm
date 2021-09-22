package P11047;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] coin;

    static int upperbound(int val) {
        int l = 0, r = coin.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (coin[mid] > val) r = mid;
            else l = mid + 1;
        }

        return l - 1;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P11047/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        coin = new int[n];
        for (int i = 0; i < n; i++) coin[i] = Integer.parseInt(br.readLine());

        int ans = 0;
        while (k > 0) {
            int idx = upperbound(k);
            int val = k / coin[idx];
            ans += val;
            k -= coin[idx] * val;
        }
        System.out.println(ans);
    }
}
