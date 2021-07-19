package P10868;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] tree, arr;

    static int init(int node, int start, int end) {
        if (start == end) return tree[node] = arr[start];
        int mid = (start + end) / 2;
        return tree[node] = Math.min(init(2 * node, start, mid), init(2 * node + 1, mid + 1, end));
    }

    static int query(int node, int start, int end, int left, int right) {
        if (end < left || right < start) return Integer.MAX_VALUE;
        if (left <= start && end <= right) return tree[node];
        int mid = (start + end) / 2;
        return Math.min(query(2 * node, start, mid, left, right), query(2 * node + 1, mid + 1, end, left, right));
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P10868/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        tree = new int[N * 4];

        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(br.readLine());
        init(1, 1, N);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            int ans = query(1, 1, N, left, right);
            System.out.println(ans);
        }
    }
}
