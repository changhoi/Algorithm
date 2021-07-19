package P2357;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Pair {
    int min, max;

    public Pair(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public String toString() {
        return min + " " + max;
    }
}

public class Main {
    static int[] arr;
    static Pair[] tree;

    static int N, M;

    static Pair init(int node, int start, int end) {
        if (start == end) return tree[node] = new Pair(arr[start], arr[start]);
        int mid = (end + start) / 2;
        Pair left = init(2 * node, start, (end + start) / 2);
        Pair right = init(2 * node + 1, mid + 1, end);
        return tree[node] = new Pair(Math.min(left.min, right.min), Math.max(left.max, right.max));
    }

    static Pair query(int node, int start, int end, int left, int right) {
        // left, right가 구간, start, end는 tree의 인덱스
        if (start >= left && right >= end) return tree[node];
        if (end < left || right < start) return null;
        int mid = (start + end) / 2;
        Pair l = query(2 * node, start, mid, left, right);
        Pair r = query(2 * node + 1, mid + 1, end, left, right);
        if (l == null && r == null) return null;
        if (l == null) return r;
        if (r == null) return l;

        return new Pair(Math.min(l.min, r.min), Math.max(l.max, r.max));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        tree = new Pair[N * 4];

        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(br.readLine());
        init(1, 1, N);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            Pair ans = query(1, 1, N, left, right);
            System.out.println(ans);
        }
    }
}
