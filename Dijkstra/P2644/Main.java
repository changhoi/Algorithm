package P2644;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m, t1, t2;


    static List<Integer>[] edges;
    static boolean[] visited;
    static int[] dist;

    static void dijkstra() {
        dist = new int[n];
        for (int i = 0; i < n; i++) dist[i] = Integer.MAX_VALUE;
        dist[t1 - 1] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(t1);

        while (!queue.isEmpty()) {
            int target = queue.poll();

            for (int to : edges[target - 1]) {
                if (!visited[target - 1] && dist[to - 1] > dist[target - 1] + 1) {
                    dist[to - 1] = dist[target - 1] + 1;
                    queue.add(to);
                }

                if (to == t2) {
                    System.out.println(dist[t2 - 1]);
                    return;
                }
            }
            visited[target - 1] = true;
        }
        System.out.println(-1);
    }

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/P2644/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        visited = new boolean[n];
        edges = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }

        t1 = Integer.parseInt(st.nextToken());
        t2 = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            edges[x - 1].add(y);
            edges[y - 1].add(x);
        }

        dijkstra();
    }
}
