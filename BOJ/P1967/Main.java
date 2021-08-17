package P1967;

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

    static List<Edge>[] edges;

    static int[] bfs(int node, boolean[]visited) {
        List<Edge> nodeEdges = edges[node];
        int[] ret = new int[]{0, node};
        visited[node] = true;
        for (Edge e : nodeEdges) {
            if (visited[e.to]) continue;
            int[] path  = bfs(e.to, visited);
            if(path[0] + e.weight > ret[0]) {
                ret[0] = path[0] + e.weight;
                ret[1] = path[1];
            }
        }

        visited[node] = false;
        return ret;
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1967/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        edges = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[parent].add(new Edge(child, weight));
            edges[child].add(new Edge(parent, weight));
        }

        int[] p1 = bfs(1, new boolean[n + 1]);
        int[] p2 = bfs(p1[1], new boolean[n + 1]);
        System.out.println(p2[0]);
    }
}
