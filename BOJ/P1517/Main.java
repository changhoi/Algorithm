package P1517;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] tree, arr;
    static long answer = 0;

    static int[] merge(int[] a, int[] b) {
        int len = a.length + b.length, l, r, idx = l = r = 0;

        int[] ret = new int[len];
        while (l < a.length && r < b.length) {
            if (a[l] > b[r]) {
                answer += a.length - l;
                ret[idx++] = b[r++];
            } else ret[idx++] = a[l++];
        }

        while(l < a.length) ret[idx++] = a[l++];
        while(r < b.length) ret[idx++] = b[r++];
        return ret;
    }

    static int[] init(int start, int end) {
        if (start == end) return new int[]{arr[start]};

        int mid = (start + end) / 2;
        int[] left = init(start, mid);
        int[] right = init(mid + 1, end);

        return merge(left, right);
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1517/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        tree = new int[4 * n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        init(0, n - 1);
        System.out.println(answer);
    }
}
