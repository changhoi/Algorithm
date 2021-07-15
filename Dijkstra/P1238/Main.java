package P1238;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

class Edge {
    int to, weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class Main {
    static int n, m, x;
    static List<Edge>[] edges;
    static List<Edge>[] reverse;
    static int[] dist1;
    static int[] dist2;

    static boolean[] visisted;

    static int getIdx(Set<Integer> set, int[] dist) {
        int min = -1;
        int val = Integer.MAX_VALUE;
        for (int idx : set) {
            if (dist[idx] == Integer.MAX_VALUE || visisted[idx]) continue;
            if (val > dist[idx]) {
                val = dist[idx];
                min = idx;
            }
        }

        return min;
    }

    static int[] initDist() {
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) ret[i] = Integer.MAX_VALUE;
        ret[x] = 0;
        return ret;
    }

    static void dijkstra(int d) {
        List<Edge>[] map;
        int[] dist;
        if (d == -1) {
            map = reverse;
            dist = dist2;
        } else {
            map = edges;
            dist = dist1;
        }

        visisted = new boolean[n];
        Set<Integer> set = new HashSet<>();
        set.add(x);

        while (true) {
            int idx = getIdx(set, dist);
            if (idx == -1) break;

            for (Edge e : map[idx]) {
                if (visisted[e.to]) continue;
                if (dist[e.to] > dist[idx] + e.weight) {
                    set.add(e.to);
                    dist[e.to] = dist[idx] + e.weight;
                }
            }

            set.remove(idx);
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1238/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken()) - 1;
        edges = new ArrayList[n];
        reverse = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            edges[u].add(new Edge(v, w));
            reverse[v].add(new Edge(u, w));
        }
        dist1 = initDist();
        dist2 = initDist();

        dijkstra(1);
        dijkstra(-1);
        int max = 0;
        for (int i = 0; i < n; i++) {
            int val = dist1[i] + dist2[i];
            max = Math.max(max, val);
        }

        System.out.println(max);
    }
}
