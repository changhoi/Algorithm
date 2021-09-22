package P2606;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] edges;
    static boolean[] visited;
    static int cnt = 0;

    static void dfs(int idx) {
        visited[idx] = true;
        cnt++;
        for(int to : edges[idx]) {
            if (visited[to]) continue;
            dfs(to);
        }
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2606/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            edges[from].add(to);
            edges[to].add(from);
        }

        dfs(1);
        System.out.println(cnt - 1);
    }
}
