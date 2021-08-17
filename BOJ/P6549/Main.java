package P6549;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int init(int[] arr, int[] tree, int node, int start, int end) {
        if (start == end) return tree[node] = start;
        else {
            int mid = (start + end) / 2;
            init(arr, tree, node * 2, start, mid);
            init(arr, tree, node * 2 + 1, mid + 1, end);
            int ret = arr[tree[node * 2]] < arr[tree[node * 2 + 1]] ? tree[node] = tree[node * 2] : tree[node * 2 + 1];
            return tree[node] = ret;
        }
    }

    static int query(int[] tree, int[] arr, int node, int start, int end, int left, int right) {
        if (right < start || left > end) return -1;
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        int i = query(tree, arr, node * 2, start, mid, left, right);
        int j = query(tree, arr, node * 2 + 1, mid + 1, end, left, right);
        if (i != -1 && j == -1) return i;
        if (i == -1 && j != -1) return j;
        if (i == -1) return -1;

        return arr[i] < arr[j] ? i : j;
    }

    static long getMax(int[] tree, int[] arr, int left, int right) {
        int m = query(tree, arr, 1, 0, arr.length - 1, left, right);
        long area = (right - left + 1) * (long) arr[m];
        if (m < right) area = Math.max(area, getMax(tree, arr, m + 1, right));
        if (m > left) area = Math.max(area, getMax(tree, arr, left, m - 1));
        return area;
    }

    static void solution(int[] arr) {
        int[] tree = new int[arr.length * 4];
        init(arr, tree, 1, 0, arr.length - 1);
        System.out.println(getMax(tree, arr, 0, arr.length - 1));
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P6549/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

            solution(arr);
        }
    }
}
