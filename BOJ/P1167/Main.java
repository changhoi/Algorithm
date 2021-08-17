package P1167;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Edge {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static int[] dfs(int node, boolean[] visited) {
        int[] ret = new int[]{node, 0};
        visited[node] = true;

        for (Edge e : edges[node]) {
            if (visited[e.to]) continue;
            int[] path = dfs(e.to, visited);
            if (path[1] + e.weight > ret[1]) {
                ret[1] = path[1] + e.weight;
                ret[0] = path[0];
            }
        }

        visited[node] = false;
        return ret;
    }

    static List<Edge>[] edges;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1167/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        edges = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) edges[i] = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                edges[node].add(new Edge(to, weight));
            }
        }

        int[] p1 = dfs(1, new boolean[v + 1]);
        int[] p2 = dfs(p1[0], new boolean[v + 1]);
        System.out.println(p2[1]);
    }
}
