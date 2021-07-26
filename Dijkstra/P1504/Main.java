package P1504;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, E, v1, v2;
    static List<Edge>[] edges;
    static boolean[] visited;
    static int[][] dist = new int[3][];

    static class Edge {
        int to, weight;

        @Override
        public String toString() {
            return "Edge{" +
                    "to=" + to +
                    ", weight=" + weight +
                    '}';
        }

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static int getMinIdx(int[] dist, Set<Integer> set) {
        int idx = -1, val = Integer.MAX_VALUE;
        for (int i : set) {
            if (!visited[i] && dist[i] < val) {
                idx = i;
                val = dist[i];
            }
        }

        return idx;
    }

    static void dijkstra(int[] dist, int start) {
        visited = new boolean[N];
        dist[start] = 0;
        Set<Integer> set = new HashSet<>();
        set.add(start);

        while (true) {
            int idx = getMinIdx(dist, set);
            if (idx == -1) break;

            for (Edge e : edges[idx]) {
                if (!visited[e.to] && dist[e.to] > dist[idx] + e.weight) {
                    dist[e.to] = dist[idx] + e.weight;
                    set.add(e.to);
                }
            }
            visited[idx] = true;
            set.remove(idx);
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1504/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dist[0] = new int[N];
        dist[1] = new int[N];
        dist[2] = new int[N];

        edges = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            edges[i] = new ArrayList<>();
            dist[0][i] = dist[1][i] = dist[2][i] = Integer.MAX_VALUE;
        }

        E = Integer.parseInt(st.nextToken());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            edges[from].add(new Edge(to, weight));
            edges[to].add(new Edge(from, weight));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken()) - 1;
        v2 = Integer.parseInt(st.nextToken()) - 1;


        dijkstra(dist[0], 0);
        dijkstra(dist[1], v1);
        dijkstra(dist[2], v2);

        int path1 = Integer.MAX_VALUE;
        int path2 = Integer.MAX_VALUE;

        if (dist[0][v1] != Integer.MAX_VALUE && dist[1][v2] != Integer.MAX_VALUE && dist[2][N - 1] != Integer.MAX_VALUE) {
            path1 = dist[0][v1] + dist[1][v2] + dist[2][N - 1];
        }

        if (dist[0][v2] != Integer.MAX_VALUE && dist[2][v1] != Integer.MAX_VALUE && dist[1][N - 1] != Integer.MAX_VALUE) {
            path2 = dist[0][v2] + dist[2][v1] + dist[1][N - 1];
        }
        int ans = Math.min(path1, path2);
        if (ans == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(ans);
    }
}
