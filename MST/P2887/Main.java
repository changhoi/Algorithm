package P2887;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Edge[] edges;

    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", weight=" + weight +
                    '}';
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }


    static int cost(int p1, int p2) {
        return Math.abs(p1 - p2);
    }

    static void makeSet() {
        parent = new int[N];
        for (int i = 0; i < N; i++) parent[i] = i;
    }

    static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        if (aRoot == bRoot) return false;

        parent[bRoot] = aRoot;
        return true;
    }

    static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2887/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        edges = new Edge[(N - 1) * 3];
        int[][][] space = new int[3][N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            space[0][i] = new int[]{i, x};
            space[1][i] = new int[]{i, y};
            space[2][i] = new int[]{i, z};
        }
        Arrays.sort(space[0], Comparator.comparingInt(a -> a[1]));
        Arrays.sort(space[1], Comparator.comparingInt(a -> a[1]));
        Arrays.sort(space[2], Comparator.comparingInt(a -> a[1]));

        for (int i = 0; i < N - 1; i++) {
            int idx = i * 3;
            edges[idx++] = new Edge(space[0][i][0], space[0][i + 1][0], cost(space[0][i][1], space[0][i + 1][1]));
            edges[idx++] = new Edge(space[1][i][0], space[1][i + 1][0], cost(space[1][i][1], space[1][i + 1][1]));
            edges[idx] = new Edge(space[2][i][0], space[2][i + 1][0], cost(space[2][i][1], space[2][i + 1][1]));
        }

        Arrays.sort(edges);
        makeSet();

        int cnt = 0, ans = 0;

        for (Edge e : edges) {
            if (union(e.from, e.to)) {
                cnt++;
                ans += e.weight;
                if (cnt == N - 1) break;
            }
        }
        System.out.println(ans);
    }
}
