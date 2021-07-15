package P1916;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Edge {
    int to, weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }
}

public class Main {
    static int n, m, start, end;
    static boolean[] visited;
    static int[] dist;
    static List<Edge>[] edges;

    static int getMinIdx() {
        int val = Integer.MAX_VALUE;
        int idx = -1;

        for (int i = 0; i < n; i++) {
            if (visited[i] || dist[i] == Integer.MAX_VALUE) continue;
            if (dist[i] < val) {
                val = dist[i];
                idx = i;
            }
        }
        return idx;
    }

    static void dijkstra() {
        while (true) {
            int idx = getMinIdx();
            if (idx == end) return;

            for (Edge e : edges[idx]) {
                if (visited[e.to]) continue;
                dist[e.to] = Math.min(dist[idx] + e.weight, dist[e.to]);
            }

            visited[idx] = true;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1916/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) dist[i] = Integer.MAX_VALUE;

        edges = new ArrayList[n];
        for (int i = 0; i < n; i++) edges[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            edges[from].add(new Edge(to, weight));
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken()) - 1;
        end = Integer.parseInt(st.nextToken()) - 1;

        dist[start] = 0;
        dijkstra();
        System.out.println(dist[end]);
    }
}
