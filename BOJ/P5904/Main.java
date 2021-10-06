package P5904;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static char S(int level, int size, int n) {
        int mid = (level + 3);
        int l = (size - mid) / 2;
        int r = l + mid + 1;

        if (l + 1 < n && n < r) return 'o';
        if (l + 1 == n || r == n) return 'm';
        if (l >= n) return S(level - 1, l, n);
        else return S(level - 1, size - l - mid, n - l - mid);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 3;
        int level = 0;
        while (cnt < n) {
            level++;
            cnt += cnt + level + 3;
        }

        System.out.println(S(level, cnt, n));
    }
}
