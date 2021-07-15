package P1753;

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
    static int[] dist;
    static boolean[] visited;
    static int v, e, start;
    static List<Edge>[] edges;

    static int getMinNode() {
        int ret = -1;
        int val = Integer.MAX_VALUE;
        for (int i = 0; i < v; i++) {
            if (dist[i] == Integer.MAX_VALUE || visited[i]) continue;
            if (val > dist[i]) {
                val = dist[i];
                ret = i;
            }
        }

        return ret;
    }

    public static void dijkstra() {
        while (true) {
            int idx = getMinNode();
            if (idx == -1) return;

            for (Edge e : edges[idx]) {
                if (visited[e.to]) continue;
                dist[e.to] = Math.min(dist[e.to], dist[idx] + e.weight);
            }
            visited[idx] = true;
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1753/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine()) - 1;

        visited = new boolean[v];
        dist = new int[v];
        edges = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            dist[i] = Integer.MAX_VALUE;
            edges[i] = new ArrayList<Edge>();
        }
        dist[start] = 0;


        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());
            edges[u].add(new Edge(v, w));
        }

        dijkstra();
        for (int d : dist) {
            if (d != Integer.MAX_VALUE) System.out.println(d);
            else System.out.println("INF");
        }
    }
}
