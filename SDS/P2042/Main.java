package P2042;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static long[] arr;
    static HashMap<Integer, Long> tree = new HashMap<>();

    static long init(int node, int start, int end) {
        if (start == end) {
            tree.put(node, arr[start]);
            return arr[start];
        } else {
            long val = init(node * 2, start, (start + end) / 2) + init(node * 2 + 1, (start + end) / 2 + 1, end);
            tree.put(node, val);
            return val;
        }
    }

    static void update(int node, int start, int end, int idx, long diff) {
        if (idx < start || idx > end) return; // 탐색 종료

        tree.put(node, tree.get(node) + diff);
        if (start != end) {
            update(node * 2, start, (start + end) / 2, idx, diff);
            update(node * 2 + 1, (start + end) / 2 + 1, end, idx, diff);
        }
    }

    static long sum(int node, int start, int end, int left, int right) {
        if (left > end || right < start) return 0;
        if (left <= start && end <= right) return tree.get(node);
        return sum(node * 2, start, (start + end) / 2, left, right) + sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2042/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1, 2, 6, 4, 2
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];

        for (int i = 1; i <= N; i++) arr[i] = Long.parseLong(br.readLine());
        init(1, 1, N);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            if (v1 == 1) {
                long v3 = Long.parseLong(st.nextToken());
                long diff = v3 - arr[v2];
                arr[v2] = v3;
                update(1, 1, N, v2, diff);
            } else {
                int v3 = Integer.parseInt(st.nextToken());
                System.out.println(sum(1, 1, N, v2, v3));
            }
        }
    }
}
