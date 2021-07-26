package P11779;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] dist;
    static boolean[] visited;
    static List<Edge>[] edges;

    static class Edge {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static int getMinIdx(Set<Integer> set) {
        int min = Integer.MAX_VALUE;
        int idx = -1;
        for (int i : set) {
            if (visited[i]) continue;
            if (min > dist[i][1]) {
                idx = i;
                min = dist[i][1];
            }
        }

        return idx;
    }

    static void dijkstra(int start, int end) {
        Set<Integer> set = new HashSet<>();
        set.add(start);
        dist[start][1] = 0;

        while (true) {
            int idx = getMinIdx(set);
            if (idx == end) break;

            for (Edge e : edges[idx]) {
                if (!visited[e.to] && dist[e.to][1] > dist[idx][1] + e.weight) {
                    dist[e.to][0] = idx;
                    dist[e.to][1] = dist[idx][1] + e.weight;
                    set.add(e.to);
                }
            }
            set.remove(idx);
            visited[idx] = true;
        }

        StringBuilder sb = new StringBuilder();
        int point = end;
        int cnt = 1;
        while (true) {
            sb.insert(0, point + " ");
            point = dist[point][0];
            cnt++;
            if (point == start) break;
        }
        sb.insert(0, start + " ");

        System.out.println(Arrays.deepToString(dist));

        System.out.println(dist[end][1]);
        System.out.println(cnt);
        System.out.println(sb.toString().trim());
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P11779/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        edges = new ArrayList[n + 1];
        dist = new int[n + 1][2];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            dist[i][0] = -1;
            dist[i][1] = Integer.MAX_VALUE;
            edges[i] = new ArrayList<>();
        }

        m = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges[from].add(new Edge(to, weight));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start, end);
    }
}
