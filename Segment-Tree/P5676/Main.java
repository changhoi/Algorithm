package P5676;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int getSign(int n) {
        if (n < 0) return -1;
        else if (n == 0) return n;
        else return 1;
    }

    static int init(int node, int start, int end, int[] tree, int[] arr) {
        if (start == end) return tree[node] = getSign(arr[start]);

        int mid = (start + end) / 2;
        return tree[node] = init(2 * node, start, mid, tree, arr) * init(2 * node + 1, mid + 1, end, tree, arr);
    }

    static int update(int idx, int node, int start, int end, int[] tree, int[] arr) {
        if (start > idx || end < idx) return tree[node];
        if (start == end) return tree[node] = getSign(arr[idx]);

        int mid = (start + end) / 2;
        return tree[node] = update(idx, 2 * node, start, mid, tree, arr) * update(idx, 2 * node + 1, mid + 1, end, tree, arr);
    }

    static int query(int l, int r, int node, int start, int end, int[] tree) {
        if (l <= start && end <= r) return tree[node];
        if (start > r || l > end) return 1;

        int mid = (start + end) / 2;
        return query(l, r, 2 * node, start, mid, tree) * query(l, r, 2 * node + 1, mid + 1, end, tree);
    }

    static String solution(int[] arr, int n, String[] commands) {
        int[] tree = new int[4 * (n + 1)];
        init(1, 1, n, tree, arr);

        StringBuilder sb = new StringBuilder();
        for (String c : commands) {
            StringTokenizer st = new StringTokenizer(c);
            String t = st.nextToken();
            int i = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if (t.equals("C")) {
                arr[i] = v;
                update(i, 1, 1, n, tree, arr);
            } else {
                int val = query(i, v, 1, 1, n, tree);
                if (val == 1) sb.append("+");
                else if (val == -1) sb.append("-");
                else sb.append(0);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P5676/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line == null) return;
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[n + 1];
            for (int j = 1; j <= n; j++) arr[j] = Integer.parseInt(st.nextToken());
            String[] commands = new String[k];
            for (int j = 0; j < k; j++) commands[j] = br.readLine();
            System.out.println(solution(arr, n, commands));
        }
    }
}
