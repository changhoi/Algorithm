package P2268;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static long[] arr, tree;

    static void update(int node, int start, int end, int idx, long diff) {
        if (idx < start || idx > end) return;

        tree[node] += diff;
        if (start != end) {
            int mid = (start + end) / 2;
            update(2 * node, start, mid, idx, diff);
            update(2 * node + 1, mid + 1, end, idx, diff);
        }
    }

    static long find(int node, int start, int end, int left, int right) {
        if (start > right || end < left) return 0;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return find(2 * node, start, mid, left, right) + find(2 * node + 1, mid + 1, end, left, right);
    }

    static void modify(int i, int k) {
        long origin = arr[i];
        long diff = k - origin;
        arr[i] = k;
        update(1, 1, n, i, diff);
    }

    static long sum(int i, int j) {
        if (i > j) {
            int temp = i;
            i = j;
            j = temp;
        }
        return find(1, 1, n, i, j);
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2268/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new long[n + 1];
        tree = new long[n * 4];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switch (command) {
                case 0:
                    sb.append(sum(a, b)).append("\n");
                    break;
                case 1:
                    modify(a, b);
                    break;
                default:
                    break;
            }
        }
        System.out.print(sb);
    }
}
