package P1260;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] edges;

    static void dfs(int idx, boolean[] visited, StringBuilder sb) {
        visited[idx] = true;
        sb.append(idx).append(" ");
        for (int e : edges[idx]) {
            if (visited[e]) continue;
            dfs(e, visited, sb);
        }
    }

    static void bfs(int idx, StringBuilder sb) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(idx);
        boolean[] visited = new boolean[edges.length + 1];
        while(!queue.isEmpty()) {
            int next = queue.poll();
            if (visited[next]) continue;
            visited[next] = true;
            sb.append(next).append(" ");
            queue.addAll(edges[next]);
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P1260/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        edges = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) edges[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            edges[from].add(to);
            edges[to].add(from);
        }
        for(List<Integer> list : edges) list.sort(null);

        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        dfs(v, new boolean[n + 1], first);
        bfs(v, second);
        System.out.println(first.toString().trim());
        System.out.println(second.toString().trim());
    }
}
