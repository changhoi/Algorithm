package P1275;

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
            long val = arr[start];
            tree.put(node, val);
            return val;
        } else {
            int mid = (start + end) / 2;
            long val = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
            tree.put(node, val);
            return val;
        }
    }

    static long find(int node, int start, int end, int left, int right) {
        if (left <= start && right >= end) return tree.get(node);
        if (left > end || right < start) return 0;

        int mid = (start + end) / 2;
        return find(node * 2, start, mid, left, right) + find(node * 2 + 1, mid + 1, end, left, right);
    }

    static void update(int node, int start, int end, int idx, long diff) {
        if (start <= idx && end >= idx) {
            tree.put(node, tree.get(node) + diff);
            if (start != end) {
                int mid = (start + end) / 2;
                update(node * 2, start, mid, idx, diff);
                update(node * 2 + 1, mid + 1, end, idx, diff);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1275/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        init(1, 0, N - 1);

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken()) - 1;
            int right = Integer.parseInt(st.nextToken()) - 1;

            if (left > right) {
                int t = left;
                left = right;
                right = t;
            }

            int idx = Integer.parseInt(st.nextToken()) - 1;
            int val = Integer.parseInt(st.nextToken());
            System.out.println(find(1, 0, N - 1, left, right));
            long diff = val - arr[idx];
            arr[idx] = val;
            update(1, 0, N - 1, idx, diff);
        }
    }
}
