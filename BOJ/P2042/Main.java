package DAY03.P2042;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int c, p1, p2;
    static long[] nums;
    static long[] tree;
    static int leafSize, depth;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nums = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            nums[i] = Long.parseLong(br.readLine());
        }

        depth = 0;
        while (Math.pow(2, depth) < N) {
            depth++;
        }

        leafSize = (int) Math.pow(2, depth);
        tree = new long[(int) (Math.pow(2, depth + 1))];
        makeTree(1, 1, leafSize);

//      System.out.println(Arrays.toString(tree));

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            c = Integer.parseInt(st.nextToken());
            p1 = Integer.parseInt(st.nextToken());
            p2 = Integer.parseInt(st.nextToken());
//          System.out.println(c + ", " + p1 + ", " + p2);
            if (c == 1) {
                long diff = p2 - nums[p1];
                nums[p1] = p2;
                update(1, 1, leafSize, p1, diff);
            } else if (c == 2) {
                System.out.println(query(1, 1, leafSize, p1, p2));
            }
        }
    }

    static long makeTree(int node, int left, int right) {
        if (left == right) {
            if (left <= N) {
                return tree[node] = nums[left];
            } else {
                return tree[node] = 0;
            }
        }

        int mid = (left + right) / 2;
        tree[node] = makeTree(node * 2, left, mid);
        tree[node] += makeTree(node * 2 + 1, mid + 1, right);

        return tree[node];
    }

    static long query(int node, int left, int right, int qLeft, int qRight) {
        if (qRight < left || right < qLeft) {
            return 0;
        } else if (qLeft <= left && right <= qRight) {
            return tree[node];
        } else {
            int mid = (left + right) / 2;
            return query(node * 2, left, mid, qLeft, qRight) + query(node * 2 + 1, mid + 1, right, qLeft, qRight);
        }
    }

    static void update(int node, int left, int right, int index, long diff) {
        if (index < left || right < index) {
            return;
        } else {
            tree[node] += diff;
            if (left != right) {
                int mid = (left + right) / 2;
                update(node * 2, left, mid, index, diff);
                update(node * 2 + 1, mid + 1, right, index, diff);
            }
        }
    }
}