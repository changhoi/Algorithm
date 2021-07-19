package P11505;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static long[] tree, arr;
    static long MOD = 1000000007;

    static long init(int node, int start, int end) {
        if (start == end) return tree[node] = arr[start];
        int mid = (start + end) / 2;
        return tree[node] = (init(2 * node, start, mid) * init(2 * node + 1, mid + 1, end)) % MOD;
    }

    static long update(int node, int start, int end, int idx, int change) {
        if (start > idx || end < idx) return tree[node];
        if (start == end) return tree[node] = change;

        int mid = (start + end) / 2;
        return tree[node] = (update(2 * node, start, mid, idx, change) * update(2 * node + 1, mid + 1, end, idx, change)) % MOD;
    }

    static long query(int node, int start, int end, int left, int right) {
        if (start > right || end < left) return 1;
        if (left <= start && right >= end) return tree[node];
        int mid = (start + end) / 2;
        return query(2 * node, start, mid, left, right) * query(2 * node + 1, mid + 1, end, left, right) % MOD;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P11505/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        tree = new long[N * 4];

        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(br.readLine());
        init(1, 1, N);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (op == 1) {
                arr[a] = b;
                update(1, 1, N, a, b);
            } else System.out.println(query(1, 1, N, a, b));
        }
    }
}
